#include <bits/stdc++.h>

using namespace std;

//1 =========  Using n & ~(n-1)  ===========

/*
	//5 ========  Concept  ==========
	1. find xor of all the elements now we have 2 elements xor as result use n & ~(n-1) this sets the right most bit and rest all 0.
	2. a bit is 1 only if both the bits are different so we will separate them into 2 buckets and find xor of all them the elements from each bucket is answer.


*/


class Solution {
  public:
    vector<int> singleNumber(vector<int>& arr) {
        int n = arr.size();
        int xored = 0;
        for(auto i : arr) xored ^= i;
        
        int rsetidx = xored & ~(xored-1);
        
        int lb = 0;
        int rb = 0;
        
        for(auto i : arr){
            if(rsetidx & i){
                lb ^= i;
            }else{
                rb ^= i;
            }
        }
        
        if (lb > rb) {
            return vector<int>{rb, lb};
        } else {
            return vector<int>{lb, rb};
        }
    }
};