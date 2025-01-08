#include <bits/stdc++.h>

using namespace std;

//1 =========  Using n & (n-1) =========

/*
	//5 ====== Concept ==========
	1. find the xor so that we can get the res as set bits where the bits are different.
	2. now count the set bits.

*/

class Solution{
    public:
    // Function to find number of bits needed to be flipped to convert A to B
    int countBitsFlip(int a, int b){
        
        int res = a ^ b;
        int count = 0;
        while(res > 0){
            res = res & (res-1);
            count++;
        }
        
        return count;
        
    }
};


//2 =========  Using traversal =========

/*
	//5 ====== Concept ==========
	1. right shift one by one till we get 0 and compare alongside

*/



class Solution{
    public:
    // Function to find number of bits needed to be flipped to convert A to B
    int countBitsFlip(int a, int b){
        
        int count = 0;
		while(a > 0 || b > 0){
			if((a & 1) != (b & 1)) count++;
			a = a >> 1;
			b = b >> 1;
		}

		return count;
        
    }
};