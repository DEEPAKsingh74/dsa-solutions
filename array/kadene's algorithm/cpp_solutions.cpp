#include <bits/stdc++.h>

using namespace std;

//1 ================  brute force  =================

/*
	//5 =================  concept  ===================
	1. formm all the subarray and find the max sum.

	//5 ================ Complexity  ====================

	Time: O(N^2)
	Space: O(1)

*/

class Solution {
  public:
    int maxSubarraySum(vector<int> &arr) {
        int n = arr.size();
		int ans = INT_MIN;
		for(int i = 0; i < n; i++){
			int sum = 0;
			for(int j = i; j < n; j++){
				sum += arr[j];
				ans = max(ans, sum);
				if(sum < 0) sum = 0;
			}
		}

		return ans;
    }
};


//1 ================  Algorithm  =================

/*
	//5 =================  concept  ===================
	1. formm all the subarray and find the max sum.

	//5 ================ Complexity  ====================

	Time: O(N)
	Space: O(1)

*/


class Solution {
  public:
    int maxSubarraySum(vector<int> &arr) {
        int n = arr.size();
		int ans = INT_MIN;
		int sum = 0;
		for(int i = 0; i < n; i++){
			sum += arr[i];
			ans = max(ans, sum);
			if(sum < 0) sum = 0;
		}

		return ans;
    }
};