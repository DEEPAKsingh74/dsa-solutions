import java.util.*;


//1 ===========  Using monotonic stack  =========

/*

	//5 ======  Concept  =========
	1. we need to find the max(arr[i] * (nsi-psi-1)).
	2. to solve in one go use a monotonic stack : It stores numbers in increasing order so for every element the just previous element is the psi and for every element nsi is found when we pop elements from the stack.

*/

class Solution {
    public int getMaxArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>(); // To store indices
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // Get the height of the bar
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Calculate width
                maxArea = Math.max(maxArea, height * width); // Update max area
            }
            stack.push(i); // Push current index
        }

        return maxArea;
    }

}
