#include <bits/stdc++.h>

using namespace std;

//1 =========  Using window size  ==========

/*
	//5 ========  Concept ==========
	1. Find the window size of the #elements less than equal to k;
	2. find non favourable elements count in each window and return min of all these.

	//5 =======  Complexity ===========
	Time: O(n)
	Space: O(1)

*/

class Solution {
  public:
    int minSwap(vector<int>& arr, int k) {
        int n = arr.size();
        int ws = 0;
        for(auto i : arr){
            if(i <= k) ws++;
        }
        
        int s = 0;
        int nfav = 0;
        int e = ws-1;
        int ans = INT_MAX;
        for(int i = 0; i < ws; i++){
            if(arr[i] > k) nfav++;
        }
        
        ans = min(ans, nfav);
        
        for(int i = ws; i < n; i++){
            if(arr[i-ws] > k) nfav--;
            if(arr[i] > k) nfav++;
            
            ans = min(ans, nfav);
        }
        
        return ans;
    }
};