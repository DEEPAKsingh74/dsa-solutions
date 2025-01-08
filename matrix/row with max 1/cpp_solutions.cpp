#include <bits/stdc++.h>

using namespace std;

//1 ============  Using Binary Search  =====

/*
	//5 =====  Concept  =======
	1. Find the lower bound of each row with target 1 the one with lowest lower bound is the ans;

*/

class Solution {
  public:
    int rowWithMax1s(vector<vector<int>> &arr) {
        
        int lb = lower_bound(arr[0].begin(), arr[0].end(), 1) - arr[0].begin();
        int r = arr.size();
        int c = arr[0].size();
        int ans = INT_MAX;
        
        if(lb != c) ans = 0;
        
        for(int i = 1; i < r; i++){
            if(lb < c && arr[i][lb] == 0) continue;
            int temp = lb;
            lb = lower_bound(arr[i].begin(), arr[i].end(), 1) - arr[i].begin();
            if(temp > lb){
                ans = i;
            }
            
        }
        
        return (ans == INT_MAX) ? -1 : ans;
        
        
    }
};