//1 ============  Using Binary Search  =====

/*
	//5 =====  Concept  =======
	1. Find the lower bound of each row with target 1 the one with lowest lower bound is the ans;

*/

import java.util.*;

class Solution {
    public int rowWithMax1s(int[][] arr) {
        int r = arr.length;    // Number of rows
        int c = arr[0].length; // Number of columns

        int lb = lowerBound(arr[0], 1); // Find lower bound in the first row
        int ans = Integer.MAX_VALUE;

        if (lb != c) ans = 0;

        for (int i = 1; i < r; i++) {
            if (lb < c && arr[i][lb] == 0) continue;
            int temp = lb;
            lb = lowerBound(arr[i], 1); // Find lower bound in the current row
            if (temp > lb) {
                ans = i;
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    // Helper function to find the lower bound of a target in a sorted array
    private int lowerBound(int[] row, int target) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
