#include <bits/stdc++.h>

using namespace std;

//1 ===========  Using 3 pointers  =======

/*

	//5 ========  Concept  =========
	1. Sort array : use three pointers i, j, k
	2. i = n-1, j = i-1, k = 0;  if i get i, j, k as possible ans then all from k to j will be my answer no need to compute.

*/


class Solution {
  public:
    // Function to count the number of possible triangles.
    int countTriangles(vector<int>& arr) {
        
        int n = arr.size();
        sort(arr.begin(), arr.end());
        
        int i = n-1;
        int ans = 0;
        
        for(i; i > 1; i--){
            
            int j = i-1;
            int k = 0;
        
            while(j > k){
                if(arr[j] + arr[k] > arr[i]){
                    ans += (j-k);
                    j--;
                }else{
                    k++;
                }
            }
        }
        
        return ans;
    }
};