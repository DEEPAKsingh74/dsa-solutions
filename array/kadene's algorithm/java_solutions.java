
class Solution {

    // 1 ================ Brute Force =================

    /*
        //5 ================= Concept ===================
        1. Form all the subarrays and find the max sum.

        //5 ================= Complexity ====================
        Time: O(N^2)
        Space: O(1)
    */

    public int maxSubarraySum(int[] arr) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;

        // Iterate over all subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                ans = Math.max(ans, sum);
                if (sum < 0) sum = 0; // Reset sum if it becomes negative
            }
        }

        return ans;
    }
}


//1 ================  Algorithm  =================

/*
	//5 =================  concept  ===================
	1. formm all the subarray and find the max sum.

	//5 ================ Complexity  ====================

	Time: O(N)
	Space: O(1)

*/

class Solution2 {

    // 1 ================ Kadane's Algorithm =================

    /*
        //5 ================= Concept ===================
        1. Form all the subarrays and find the max sum.

        //5 ================= Complexity ====================
        Time: O(N)
        Space: O(1)
    */

    public int maxSubarraySum(int[] arr) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            ans = Math.max(ans, sum);
            if (sum < 0) sum = 0; // Reset sum if it becomes negative
        }

        return ans;
    }
}
