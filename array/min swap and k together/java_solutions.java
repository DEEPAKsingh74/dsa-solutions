

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
    public int minSwap(int[] arr, int k) {
        int n = arr.length;
        int ws = 0;

        // Calculate the window size (number of elements <= k)
        for (int num : arr) {
            if (num <= k) ws++;
        }

        int nfav = 0;
        int ans = Integer.MAX_VALUE;

        // Count non-favorable elements in the first window
        for (int i = 0; i < ws; i++) {
            if (arr[i] > k) nfav++;
        }

        ans = Math.min(ans, nfav);

        // Slide the window across the array
        for (int i = ws; i < n; i++) {
            if (arr[i - ws] > k) nfav--; // Remove the first element of the previous window
            if (arr[i] > k) nfav++;      // Add the next element to the current window

            ans = Math.min(ans, nfav);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 1, 5, 6, 3};
        int k = 3;
        System.out.println(solution.minSwap(arr, k)); // Output: 1
    }
}
