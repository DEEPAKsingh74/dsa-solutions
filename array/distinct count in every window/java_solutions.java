import java.util.*;


//1 ========  Using map ==========

/*
	//5 =======  Concept =========
	1. in every window count the size of window.
	2. if any element count becomes 0 remove it from the map.

*/


class Solution {
    public List<Integer> countDistinct(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        if (k > n) return result; // Edge case: window size is larger than array size

        // Initialize the first window
        for (; j < k; j++) {
            freqMap.put(arr[j], freqMap.getOrDefault(arr[j], 0) + 1);
        }
        result.add(freqMap.size()); // Add the count of distinct elements in the first window

        // Slide the window
        while (j < n) {
            // Add the next element to the window
            freqMap.put(arr[j], freqMap.getOrDefault(arr[j], 0) + 1);

            // Remove the leftmost element from the window
            freqMap.put(arr[i], freqMap.get(arr[i]) - 1);
            if (freqMap.get(arr[i]) == 0) {
                freqMap.remove(arr[i]); // Remove the element from the map if its frequency becomes 0
            }

            i++;
            result.add(freqMap.size()); // Add the count of distinct elements in the current window
            j++;
        }

        return result;
    }

}
