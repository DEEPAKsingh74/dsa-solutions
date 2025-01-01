import java.util.*;

class Solution {

    // Basic Method
    /*
        Complexity:
        Time: O(nlog(n))
        Space: O(n)
    */
    public List<List<Integer>> getPairs(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        
        // Convert array to list and sort in descending order
        Arrays.sort(arr);
        List<Integer> sortedArr = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArr.add(arr[i]);
        }
        
        Set<Integer> st = new HashSet<>();
        int zeroCount = 0;

        // Add negatives to the set and count zeros
        for (int num : sortedArr) {
            if (num == 0) zeroCount++;
            if (num < 0) st.add(num);
        }

        // Find pairs of -i and i
        for (int num : sortedArr) {
            if (num > 0 && st.contains(-num)) {
                ans.add(Arrays.asList(-num, num));
                st.remove(-num); // Ensure unique pairs
            }
        }

        // Handle case for zero pairs
        if (zeroCount > 1) {
            ans.add(Arrays.asList(0, 0));
        }

        return ans;
    }

}
