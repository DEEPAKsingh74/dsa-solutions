# Links:

- [Geeks For Geeks](https://www.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1?)

# Problem Statement :

You are given a histogram represented by an array arr, where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.

Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.

#### Examples :

Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
Output: 100
Explanation: We get the maximum are by picking bars highlighted above in green (50, and 60). The area is computed (smallest height) *  (no. of the picked bars) = 50* 2 = 100


Input: arr[] = [7, 2, 8, 9, 1, 3, 6, 5]
Output: 16
Explanation: In this example the largest area would be 16 of height 8 and width 2. We can achieve this area by choosing 3rd and 4th bars.


Input: arr[] = [3]
Output: 3
Explanation: In this example the largest area would be 3 of height 3 and width 1.

#### Constraints :

1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^3



## Related Problems :

- [Geeks For Geeks](https://www.geeksforgeeks.org/problems/max-rectangle/1)


### Optimized Solution Complexity

**_Time_** : O(n)
**_Space_** : O(n)