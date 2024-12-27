#include <bits/stdc++.h>
using namespace std;

//1 =======================  Traversal ======================

/*
	//5 ==================  Complexity  ===================

		Time: O(N)
		Space: O(1)

*/


class Solution {
	public:

		pair<int, int> minMaxArr(vector<int> &arr){
			int mini = INT_MAX;
			int maxi = INT_MIN;

			for(auto i : arr){
				mini = min(mini, i);
				maxi = max(maxi, i);
			}

			return {mini, maxi};
		}
};