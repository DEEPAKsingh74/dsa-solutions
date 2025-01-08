

//1 =========  Using n & ~(n-1)  ===========

/*
	//5 ========  Concept  ==========
	1. find xor of all the elements now we have 2 elements xor as result use n & ~(n-1) this sets the right most bit and rest all 0.
	2. a bit is 1 only if both the bits are different so we will separate them into 2 buckets and find xor of all them the elements from each bucket is answer.


*/



class Solution {
    public int[] singleNumber(int[] arr) {
        int xored = 0;

        // Step 1: XOR all elements
        for (int num : arr) {
            xored ^= num;
        }

        // Step 2: Find the rightmost set bit
        int rsetidx = xored & ~(xored - 1);

        int lb = 0, rb = 0;

        // Step 3: Divide numbers into two groups based on the rightmost set bit
        for (int num : arr) {
            if ((num & rsetidx) != 0) {
                lb ^= num;
            } else {
                rb ^= num;
            }
        }

        // Step 4: Return the result in sorted order
        if (lb > rb) {
            return new int[]{rb, lb};
        } else {
            return new int[]{lb, rb};
        }
    }

}
