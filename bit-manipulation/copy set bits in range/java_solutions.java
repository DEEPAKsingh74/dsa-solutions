//1 =============  Using masking ===========


/*
	//5 ======= Concept ==========
	1. if we have 10000 as binary and if we subtract 1 we will get => 1111(equal to number of zeroes).
	2. make an binary and operation and at last an OR operation.

*/


class Solution {
    public int setSetBit(int x, int y, int l, int r) {
        // Convert l and r to zero-based indexing
        l--; 
        r--;

        // Create a mask with bits set in the range [l, r]
        int mask = ((1 << (r - l + 1)) - 1) << l;

        // Extract the bits from y that are within the mask
        mask = mask & y;

        // Set those bits in x and return the result
        return mask | x;
    }
}
