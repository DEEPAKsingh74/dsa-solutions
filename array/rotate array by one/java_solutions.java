import java.util.*;

// 1 ====================== Basic ======================

/*
    //5 ============= Complexity  =====================
        Time: O(N)
        Space: O(1)
*/

class Solution {
    public void rotate(List<Integer> arr) {
        int element = arr.get(arr.size() - 1); // Get the last element
        arr.remove(arr.size() - 1); // Remove the last element
        arr.add(0, element); // Insert it at the beginning
    }
}

// 2 ====================== Swapping ======================

/*
    //5 ============= Complexity  =====================
        Time: O(N)
        Space: O(1)
*/

class Solution2 {
    public void rotate(List<Integer> arr) {
        int n = arr.size();

        // Swap elements from the end to the start
        for (int i = n - 1; i > 0; i--) {
            Collections.swap(arr, i, i - 1);
        }
    }
}
