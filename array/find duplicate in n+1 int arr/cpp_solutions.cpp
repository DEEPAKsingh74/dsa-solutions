#include <bits/stdc++.h>

using namespace std;

//1 =================== Slow and Fast pointers  ====================

/*
	//5 ===============  Concept  ======================

		1. If we place the index as the node and the value directed edge between the nodes we can see its a simple task of detecting cycle element in an linked list type.

	//5 =============== Complexity  ===================

*/


class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
};