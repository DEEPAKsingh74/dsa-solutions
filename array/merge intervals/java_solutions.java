//1  =================  Basic approach  ================

/*
	//5 ============ complexity  ================
	Time: O(n)
	Space: O(n^2)

*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        // Sort the intervals based on the starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length; i++) {
            // If the answer list is empty or there is no overlap
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(intervals[i]);
            } else {
                // Merge intervals
                ans.get(ans.size() - 1)[1] = Math.max(intervals[i][1], ans.get(ans.size() - 1)[1]);
            }
        }

        // Convert the list to a 2D array
        return ans.toArray(new int[ans.size()][]);
    }
}
