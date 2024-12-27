
//1 ========================  Brute Force - 2 Loops ========================
/*
	//5 ======================  Concept  ========================================

		1. Do as said just find for every possible i and j.

	//5 ======================  Complexity  ========================================
		Time: O(N^2)
		Space: O(1)
*/


class Solution {
	public int maxScoreSightseeingPair(int[] A) {
		int max = 0;
		for(int i = 0; i < A.length; i++){
			for(int j = i+1; j < A.length; j++){
				max = Math.max(max, A[i] + A[j] + i - j);
			}
		}
		return max;
	}
}


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
	public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
		int maxVals[] = new int[n];
		maxVals[0] = values[0];

		for(int i = 1; i < n; i++){
			maxVals[i] = Math.max(maxVals[i-1], values[i] + i);
		}
		int ans = 0;
		for(int j = 1; j < n; j++){
			ans = Math.max(ans, maxVals[j-1] + values[j] - j);
		}

		return ans;
    }
}


//1 ========================  Brute Force - 2 Loops ========================
/*
	//5 ======================  Concept  ========================================

		1. same as previous but we not need to maintain the array or vector we can calculate it on the fly.

	//5 ======================  Complexity  ========================================
		Time: O(N)
		Space: O(1)
*/


class Solution3 {
	public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
		int iMaxVal = values[0];
		int ans = 0;

		for(int i = 1; i < n; i++){
			ans = Math.max(ans, values[i] - i + iMaxVal);
			iMaxVal = Math.max(iMaxVal, values[i] + i);
		}

		return ans;
    }
}