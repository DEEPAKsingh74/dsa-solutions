import java.util.*;

//1 =============  Count only for minimum  =================

/*
	//5 ==================  Concept   ===================
		1. Dont count for every element just count for the minimum elements of the possible subsequence.
		2. check if the element - 1 is already present than dont count for that element.

	//5 =============== Complexity  ===============

		Time: O(n)
		space: O(n)

*/

class Solution {
	public int longestConsecutive(int[] arr) {
		Set<Integer> st = new HashSet<>();
		int n = arr.length;
		for (int i = 0; i < n; i++)
			st.add(arr[i]);
		int ans = 1;

		for (int i = 0; i < n; i++) {
			if (st.contains(arr[i] - 1))
				continue;

			int j = i;
			while (true) {
				if (st.contains(arr[j] + 1)) {
					j++;
				} else
					break;
			}

			ans = Math.max(ans, arr[j] - arr[i] + 1);
		}

		return ans;
	}
};