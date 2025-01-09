#include <bits/stdc++.h>

using namespace std;

//1 =============  Using masking ===========


/*
	//5 ======= Concept ==========
	1. if we have 10000 as binary and if we subtract 1 we will get => 1111(equal to number of zeroes).
	2. make an binary and operation and at last an OR operation.

*/

class Solution{
    public:
    int setSetBit(int x, int y, int l, int r){
        
        l--; r--;
        
        int mask = ((1 << (r - l + 1)) - 1) << l;
        
        mask = mask & y;
        
        return mask | x;
    }
};