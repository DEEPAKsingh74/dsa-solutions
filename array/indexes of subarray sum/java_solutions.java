

//1 ================  Using 2 pointers and window  ===============


/*
	//5 ============  Concept ================
	1. we need a window so we increment j till we get the sum greater than target. That is the window required now to match the target we need to increase the i value by decresing the sum.

*/


class Solution {
    public int[] subarraySum(int[] arr, int target) {
        int n = arr.length;
        
        int i = 0;
        int j = 0;
        int sum = 0;
        
        while (j < n) {
            sum += arr[j];
            j++;
            
            while (sum > target && i < j) {
                sum -= arr[i];
                i++;
            }

            if (sum == target) {
                return new int[]{i + 1, j}; // 1-based index
            }
        }
        
        return new int[]{-1}; // No subarray found
    }
}
