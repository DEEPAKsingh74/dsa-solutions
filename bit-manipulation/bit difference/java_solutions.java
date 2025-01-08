

//1 =========  Using n & (n-1) =========

/*
	//5 ====== Concept ==========
	1. find the xor so that we can get the res as set bits where the bits are different.
	2. now count the set bits.

*/

class Solution {
    // Function to find the number of bits needed to be flipped to convert A to B
    public int countBitsFlip(int a, int b) {
        int res = a ^ b; // XOR of A and B to find differing bits
        int count = 0;

        // Count the number of set bits in res
        while (res > 0) {
            res = res & (res - 1); // Clear the least significant set bit
            count++;
        }

        return count;
    }
}


//2 =========  Using traversal =========

/*
	//5 ====== Concept ==========
	1. right shift one by one till we get 0 and compare alongside

*/

class Solution2 {
    // Function to find the number of bits needed to be flipped to convert A to B
    public int countBitsFlip(int a, int b) {
        int count = 0;

        // Traverse the bits of both numbers
        while (a > 0 || b > 0) {
            if ((a & 1) != (b & 1)) { // Check if the least significant bits are different
                count++;
            }
            a = a >> 1; // Right shift A
            b = b >> 1; // Right shift B
        }

        return count;
    }
}
