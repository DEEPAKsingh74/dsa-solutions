
//1 ===================  Using bit manipulation =============

/*
	//5 ========  Concept ==========
	1. We will loop from 31 to 0 and subtract the dividend and add up the quotient.


*/

class Solution {
    public int divide(int dividend, int divisor) {
        // Handle edge cases
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Prevent overflow
        }
        
        // Determine the sign of the result
        boolean isNeg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        
        // Take absolute values (use long to prevent overflow during abs conversion)
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        
        // Perform division using bit manipulation
        long quotient = 0;
        for (int i = 31; i >= 0; i--) {
            if ((absDivisor << i) <= absDividend) {
                absDividend -= (absDivisor << i);
                quotient += (1L << i);
            }
        }
        
        // Apply the sign to the result
        quotient = isNeg ? -quotient : quotient;
        
        // Clamp the result to the 32-bit signed integer range
        if (quotient > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (quotient < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        return (int) quotient;
    }
}
