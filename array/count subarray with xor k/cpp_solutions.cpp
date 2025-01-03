#include <bits/stdc++.h>

using namespace std;

//1 ===================  Using prefix sum   ==========


/*
	//5  ==========  Concept  ======
	1. Xor till i = xor till i-k ^ xor from k to i;
	2. if we are at i and we have total xor as `X`; we know there is someone whose xor is `k` we just need to find if there is someone whose xor is `X ^ k`;

	//5 =========  Complexity  ========
	Time: O(n)
	Space: O(n)

*/


class Solution {
  public:
    long subarrayXor(vector<int> &arr, int k) {
        
        map<int, int> mp;
        mp[0] = 1;
        int total = 0;
        long count = 0;
        for(auto i : arr){
            total ^= i;
            if(mp.find(total ^ k) != mp.end()){
                count += mp[total ^ k];
            }
            
            mp[total]++;
        }
        
        return count;
    }
};