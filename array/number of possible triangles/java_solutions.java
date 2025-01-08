//1 ===========  Using 3 pointers  =======

/*

	//5 ========  Concept  =========
	1. Sort array : use three pointers i, j, k
	2. i = n-1, j = i-1, k = 0;  if i get i, j, k as possible ans then all from k to j will be my answer no need to compute.

*/


import java.util.*;

class Solution {
    // Function to count the number of possible triangles
    public int countTriangles(int[] arr) {
        int n = arr.length;
        
        // Sort the array
        Arrays.sort(arr);
        
        int ans = 0;
        
        // Iterate over the array from the last element
        for (int i = n - 1; i > 1; i--) {
            int j = i - 1;
            int k = 0;

            // Use two pointers to count valid triangles
            while (j > k) {
                if (arr[j] + arr[k] > arr[i]) {
                    ans += (j - k);
                    j--;
                } else {
                    k++;
                }
            }
        }
        
        return ans;
    }

}
