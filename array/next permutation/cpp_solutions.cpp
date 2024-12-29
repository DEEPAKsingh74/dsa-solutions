#include <bits/stdc++.h>

using namespace std;

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
public:
    void reverseArr(vector<int>& nums, int index) {
        int n = nums.size();

        for (int i = 0; i < (n - index) / 2; i++) {
            swap(nums[i + index], nums[n - i - 1]);
        }
    }

    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > nums[index]) {
                    swap(nums[index], nums[i]);
                    break;
                }
            }
        }

        reverseArr(nums, index + 1);
    }
};