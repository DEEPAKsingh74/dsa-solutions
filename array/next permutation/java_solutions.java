
//1  ================== graphical appraoch ================

/*
	//5 =========  Concept   ==================
	1. STEP -1 : [2, 3, 1] finding the element that has first downslop from last
    here ==> [2]

    2. STEP-2 : now we need to find the element which is just greater than the found index([2]) from last.

    3. STEP - 3 : swap the index and of the just greater found element.
    NOTE : STILL THE SLOPE WILL BE PERSISTENT THAT IS INCREASING FROM THE LAST.

    4. STEP - 4 : just reverse the array from index to the last so that we could find the lowest number in other terms to get a decreasing scope instead of increasing from the last.

*/

class Solution {
    private void reverseArr(int[] nums, int index) {
        int n = nums.length;

        for (int i = 0; i < (n - index) / 2; i++) {
            int temp = nums[i + index];
            nums[i + index] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        // Step 1: Find the first index from the right where nums[i] < nums[i + 1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: If such an index exists, find the first number greater than nums[index] from the end
        if (index != -1) {
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > nums[index]) {
                    // Swap nums[index] and nums[i]
                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }

        // Step 3: Reverse the elements from index + 1 to the end of the array
        reverseArr(nums, index + 1);
    }
}
