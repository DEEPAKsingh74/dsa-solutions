#include <bits/stdc++.h>

using namespace std;

//1 ===================  Using bit manipulation =============

/*
	//5 ========  Concept ==========
	1. We will loop from 31 to 0 and subtract the dividend and add up the quotient.


*/


class Solution
{
    public:
    long long divide(long long dividend, long long divisor) 
    {
        // Handle edge cases
        if (dividend == LLONG_MIN && divisor == -1) {
            return LLONG_MAX; // Prevent overflow
        }
        
        // Determine the sign of the result
        bool isNeg = ((dividend < 0) && (divisor > 0)) || 
                     ((dividend > 0) && (divisor < 0));
                     
        // Take absolute values
        long long absDividend = abs(dividend);
        long long absDivisor = abs(divisor);
        
        // Perform division using bit manipulation
        long long quotient = 0;
        for (int i = 31; i >= 0; i--) {
            if ((absDivisor << i) <= absDividend) {
                absDividend -= (absDivisor << i);
                quotient += (1LL << i);
            }
        }
        
        // Apply the sign to the result
        quotient = isNeg ? -quotient : quotient;
        
        // Clamp the result to the 32-bit signed integer range
        long long INT_MAXI = (1LL << 31) - 1;
        long long INT_MINI = -(1LL << 31);
        if (quotient > INT_MAXI) return INT_MAXI;
        if (quotient < INT_MINI) return INT_MINI;
        
        return quotient;
    }
};