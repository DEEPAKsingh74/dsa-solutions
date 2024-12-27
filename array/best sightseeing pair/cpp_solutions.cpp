#include <bits/stdc++.h>

using namespace std;

//1 ========================  Brute Force - 2 Loops ========================
/*
	//5 ======================  Concept  ========================================

		1. Do as said just find for every possible i and j.

	//5 ======================  Complexity  ========================================
		Time: O(N^2)
		Space: O(1)
*/

class Solution1 {

	public:
		int maxScoreSightseeingPair(vector<int>& values) {
			int n = values.size();
			int ans = INT_MIN;

			for(int i = 0; i < n; i++){
				for(int j = i+1; j < n; j++){
					ans = max(ans, values[i], values[j] + i - j);
				}
			}

			return ans;
		}

};


//1 ========================  Brute Force - 2 Loops ========================
/*
	//5 ======================  Concept  ========================================

		1. Take a vector to store the max values to the previous index i.e. values[i-1] + (i-1).
		2. Take the max value in the ans as max values till previous index - j + values[j].

	//5 ======================  Complexity  ========================================
		Time: O(N)
		Space: O(N)
*/

class Solution2 {

public:
	int maxScoreSightseeingPair(vector<int>& values) {
		int n = values.size();
		vector<int> maxVals(n);   // To store max value of (values[i] + i)
		maxVals[0] = values[0];

		for(int i = 1; i < n; i++){
			maxVals[i] = max(maxVals[i-1], values[i]+i);
		}
		int ans = INT_MIN;
		for(int j = 0; j < n; j++){
			ans = max(ans, maxVals[j] + values[j] - j);
		}

		return ans;
	}

};


//1 ========================  Brute Force - 2 Loops ========================
/*
	//5 ======================  Concept  ========================================

		1. same as previous but we not need to maintain the array or vector we can calculate it on the fly.

	//5 ======================  Complexity  ========================================
		Time: O(N)
		Space: O(1)
*/


class Solution3{

	public:
	int maxScoreSightseeingPair(vector<int>& values) {
		int n = values.size();
		int iMaxVal = values[0];

		int ans = INT_MIN;
		for(int i = 1; i < n; i++){
			ans = max(ans, iMaxVal - i + values[i]);
			iMaxVal = max(iMaxVal, values[i] + i);
		}

		return ans;
	}

};