//1 =================== Slow and Fast pointers  ====================

/*
	//5 ===============  Concept  ======================

		1. If we place the index as the node and the value directed edge between the nodes we can see its a simple task of detecting cycle element in an linked list type.

	//5 =============== Complexity  ===================

*/

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the starting point of the cycle
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
