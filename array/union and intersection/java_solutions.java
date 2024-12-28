import java.util.*;

class Solution {

    // 1 ====================== Using Set ======================

    /*
        //5 ================== Complexity ===================
            Time: O(N + M)
            Space: O(N + M)
    */

    // Function to return the count of number of elements in the union of two arrays.
    public int findUnion(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();

        // Add all elements of array `a` to the set
        for (int i : a) {
            set.add(i);
        }

        // Add all elements of array `b` to the set
        for (int i : b) {
            set.add(i);
        }

        // The size of the set gives the count of unique elements in the union
        return set.size();
    }

    // Function to find the intersection of two arrays
    public int findIntersection(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Count frequencies of elements in array `a`
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Check for common elements in array `b`
        for (int i : b) {
            if (map.containsKey(i)) {
                count++; // Increment the intersection count
                if (map.get(i) > 1) {
                    map.put(i, map.get(i) - 1); // Decrease frequency if more than one occurrence exists
                } else {
                    map.remove(i); // Remove the element if its frequency becomes 0
                }
            }
        }

        return count;
    }
}
