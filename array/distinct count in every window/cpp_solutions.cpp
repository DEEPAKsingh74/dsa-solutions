#include <bits/stdc++.h>

using namespace std;

//1 ========  Using map ==========

/*
	//5 =======  Concept =========
	1. in every window count the size of window.
	2. if any element count becomes 0 remove it from the map.

*/

class Solution {
  public:
    vector<int> countDistinct(vector<int> &arr, int k) {
        
        int n = arr.size();
        int i = 0;
        int j = 0;
        map<int, int> mp;
        vector<int> ans;
        
        if (k > n) return {};
        
        for(j; j < k; j++){
            mp[arr[j]]++;
        }
        
        ans.push_back(mp.size());
        
        while(j < n){
            mp[arr[j]]++;
            mp[arr[i]]--;
            if(mp[arr[i]] <= 0) mp.erase(arr[i]);
            i++;
            
            ans.push_back(mp.size());
            j++;
        }
        
        return ans;
        
    }
};