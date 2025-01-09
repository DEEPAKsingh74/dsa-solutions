//2 ==================    ERROR CODE  ===============

/*

- for the case [26, 3, 28, 7] target=52;
- Here we realized that j should always be incremented no matter what i may or may not be incremented so we need to put i in loop not j part;

class Solution {
  public:
    vector<int> subarraySum(vector<int> &arr, int target) {
        int n = arr.size();
        
        int i = 0;
        int j = 0;
        int sum = 0;
        
        while(j <= n){
            while(j < n && sum < target){
                sum += arr[j];
                j++;
            }
            
            if(sum == target){
                return {i+1, j};
            }
            
            sum -= arr[i];
            i++;
        }
        
        return {-1};
    }
};
*/

//2 ===========================================================================



#include <bits/stdc++.h>

using namespace std;

//1 ================  Using 2 pointers and window  ===============


/*
	//5 ============  Concept ================
	1. we need a window so we increment j till we get the sum greater than target. That is the window required now to match the target we need to increase the i value by decresing the sum.

*/


class Solution {
  public:
    vector<int> subarraySum(vector<int> &arr, int target) {
        int n = arr.size();
        
        int i = 0;
        int j = 0;
        int sum = 0;
        
        while(j < n) {  
            sum += arr[j];
            j++;
            
            while(sum > target && i < j) {
                sum -= arr[i];
                i++;
            }

            if(sum == target) {
                return {i + 1, j}; 
            }
        }
        
        return {-1}; 
    }
};
