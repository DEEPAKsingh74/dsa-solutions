#include <bits/stdc++.h>

using namespace std;

//1 =============  Using Map  ==========

/*
	//5 ======  Concept  =========
	1. Keep track of the sum if we get the same sum again we know because somewhere in between there must be the sum of subarray be 0.

	//5 ======  Complexity ======

	TIme: O(n)
	Space: O(n)

*/


class Solution {

	int countSubarraySum(vector<int> &arr){
		int count = 0;
		map<int, int> mp;
		int sum = 0;
		mp[0] = 1;
		int n = arr.size();
		for(int i = 0; i < n; i++){

			sum += arr[i];
			if(mp.find(arr[i]) != mp.end()){
				count += mp[arr[i]];
			}

			mp[sum]++;
		}

		return count;
	}
};