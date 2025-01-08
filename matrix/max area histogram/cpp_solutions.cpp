#include <bits/stdc++.h>

using namespace std;

//1 ===========  Using monotonic stack  =========

/*

	//5 ======  Concept  =========
	1. we need to find the max(arr[i] * (nsi-psi-1)).
	2. to solve in one go use a monotonic stack : It stores numbers in increasing order so for every element the just previous element is the psi and for every element nsi is found when we pop elements from the stack.

*/

class Solution {
  public:
    int getMaxArea(vector<int> &heights) {
        int n = heights.size();
        stack<int> st; // To store indices
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];

            while (!st.empty() && h < heights[st.top()]) {
                int height = heights[st.top()];
                st.pop();

                int width = st.empty() ? i : i - st.top() - 1; // Calculate width
                maxArea = max(maxArea, height * width);       // Update max area
            }
            st.push(i); // Push current index
        }

        return maxArea;
    }
};