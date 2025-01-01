#include <bits/stdc++.h>

using namespace std;

//1 ================== basic method  ==========

/*
	//5 ========= Complexity =============
	Time: O(nlog(n))
	Space: O(n)

*/

class Solution {
  public:
    vector<vector<int>> getPairs(vector<int>& arr) {
        vector<vector<int>> ans;
        sort(arr.begin(), arr.end(), greater<int>());
        
        set<int> st;
        int zc = 0;
        for(auto i : arr){
            if(i == 0) zc++;
            if(i < 0) st.insert(i);
        }
        
        for(auto i : arr){
            if(i > 0 && st.count(-i) > 0){
                ans.push_back({-i, i});
                st.erase(-i);
            }
        }
        
        if(zc > 1) ans.push_back({0, 0});
        
        return ans;
    }
};