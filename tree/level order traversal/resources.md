# Links:

- [Geeks For Geeks](https://www.geeksforgeeks.org/problems/level-order-traversal/1)

# Problem Statement :

Given a root of a binary tree with n nodes, the task is to find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.

#### Examples :

Input: root = [1, 3, 2]
    1
  /   \ 
 3     2
Output: [[1], [3, 2]]
Input: root = [10, 20, 30, 40, 60]
        10
     /      \
    20       30
  /   \
 40   60
Output: [[10], [20, 30], [40, 60]]
Input: root = [1, 3, 2, N, N, N, 4, 6, 5]
    1
  /   \ 
 3     2
        \
         4
        / \
       6   5
Output: [[1], [3, 2], [4], [6, 5]]

#### Constraints :

1 ≤ number of nodes ≤ 10^5
0 ≤ node->data ≤ 10^9



## Related Problems :


### Optimized Solution Complexity

**_Time_** : O(n)
**_Space_** : O(n)