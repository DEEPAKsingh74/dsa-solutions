#include <bits/stdc++.h>

using namespace std;

//1 =============  Count only for minimum  =================

/*
	//5 ==================  Concept   ===================
		1. Dont count for every element just count for the minimum elements of the possible subsequence.
		2. check if the element - 1 is already present than dont count for that element.

	//5 =============== Complexity  ===============

		Time: O(n)
		space: O(n)

*/


class Solution {
  public:

    int longestConsecutive(vector<int>& arr) {
        set<int> st;
        
        for(auto i : arr) st.insert(i);
        int ans = 1;
        
        for(auto i : arr){
            if(st.count(i-1) > 0) continue;

            int j = i;
            while(true){
                if(st.count(j+1) > 0){
                    j++;
                }
                else break;
            }
            
            ans = max(ans, j - i + 1);
        }
        
        return ans;
    }
};