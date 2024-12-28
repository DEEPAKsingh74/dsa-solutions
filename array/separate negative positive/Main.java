import java.util.*;

// 1 ====================== Using sorting ====================

/*
    //5 ================  Complexity  ====================
        Time: O(Nlog(N))
        Space: O(1)
*/

class Solution {
    public void separateNegPos(int[] arr) {
        Arrays.sort(arr);
    }
}

// 2 ====================== Using 2 pointers ====================

/*
    //5 =============== Concept  =======================
    1. Use 2 pointers: one for negative and another for positive.
       Swap when we encounter negative for larger pointer and positive for smaller pointer.

    //5 ================  Complexity  ====================
        Time: O(N)
        Space: O(1)
*/

class Solution2 {
    public void separateNegPos(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            if (arr[low] < 0) {
                low++;
            } else if (arr[high] >= 0) {
                high--;
            } else {
                // Swap elements when low is positive and high is negative
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
    }
}
