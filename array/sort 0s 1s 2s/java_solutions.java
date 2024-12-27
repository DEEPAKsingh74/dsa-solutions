import java.util.*;

// 1 ======================= Using Sorting =====================

/*
    // 5 ================== Concept =======================
        1. Sort the array.
        
    // 5 =================  Complexity  ====================
        Time: O(N log N)
        Space: O(1)
*/

class Solution {
    public void sort012(int[] arr) {
        Arrays.sort(arr); // Use Arrays.sort() to sort the array
    }
}

// 2 ======================= Using Counting =====================

/*
    // 5 ================== Concept =======================
        1. Count the number of 0s, 1s, and 2s and then replace them in the array.
        
    // 5 =================  Complexity  ====================
        Time: O(N)
        Space: O(1)
*/

class Solution2 {
    public void sort012(int[] arr) {
        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;

        // Count occurrences of 0, 1, and 2
        for (int num : arr) {
            if (num == 0) count_0++;
            if (num == 1) count_1++;
            if (num == 2) count_2++;
        }

        // Replace elements based on counts
        for (int i = 0; i < arr.length; i++) {
            if (count_0 > 0) {
                arr[i] = 0;
                count_0--;
            } else if (count_1 > 0) {
                arr[i] = 1;
                count_1--;
            } else {
                arr[i] = 2;
                count_2--;
            }
        }
    }
}

// 3 ======================= Using Dutch National Flag Algorithm =====================

/*
    // 5 ================== Concept =======================
        1. Use three pointers: low, mid, high.
        2. Move mid and swap elements such that 0 appears at the start, and 2 appears at the end. 
           1 will auto adjust.

    // 5 =================  Complexity  ====================
        Time: O(N)
        Space: O(1)
*/

class Solution3 {
    public void sort012(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[low] and arr[mid], then increment both pointers
                swap(arr, low++, mid++);
            } else if (arr[mid] == 1) {
                mid++; // Just move mid if element is 1
            } else {
                // Swap arr[mid] and arr[high], then decrement high
                swap(arr, mid, high--);
            }
        }
    }

    // Helper function to swap elements
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
