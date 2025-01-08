# Links:

- [Geeks For Geeks](https://www.geeksforgeeks.org/problems/maximum-difference-between-pair-in-a-matrix/1)

# Problem Statement :

Given an n x n matrix, mat[n][n] of integers. The task is to find the maximum value of mat(c, d)- mat(a, b) over all choices of indexes such that both c > a and d > b.

#### Examples :

Input: mat[N][N] = {{ 1, 2, -1, -4, -20 },
             { -8, -3, 4, 2, 1 }, 
             { 3, 8, 6, 1, 3 },
             { -4, -1, 1, 7, -6 },
             { 0, -4, 10, -5, 1 }};
Output: 18
Explanation: The maximum value is 18 as mat[4][2] - mat[1][0] = 18 has maximum difference.

#### Constraints :

1 <= n<= 10^3
-10^3<= mat[i][j] <=10^3



## Related Problems :


### Optimized Solution Complexity

**_Time_** : O(n^2)
**_Space_** : O(n^2)