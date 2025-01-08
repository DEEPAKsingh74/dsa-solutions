
//1 =====  USing the set bit concept  =======

/*
	//5 ==  Concept  ==========
	1. n & (n-1) switches off the set bit from right.

*/

class Solution {
    public int setBits(int n) {
        int ans = 0;
        
        // Count the number of set bits
        while (n > 0) {
            n = n & (n - 1); // Clear the least significant set bit
            ans++;
        }
        
        return ans;
    }
}