# Links:

- [Geeks For Geeks](https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1)

# Problem Statement :

Given a binary tree, the diameter (also known as the width) is defined as the number of edges on the longest path between two leaf nodes in the tree. This path may or may not pass through the root. Your task is to find the diameter of the tree.

#### Examples :

Input: root[] = [1, 2, 3]
       1
     /  \
    2    3
Output: 2
Explanation: The longest path has 2 edges (node 2 -> node 1 -> node 3).
Input: root[] = [10, 20, 30, 40, 60]
         10
        /   \
      20    30
    /   \ 
   40   60
Output: 3
Explanation:The longest path has 3 edges (node 40 -> node 20 -> node 10 -> node 30).
Input: root[] = [5, 8, 6, 3, 7, N, 9]
           5
         /   \
       8      6
      / \      \
     3   7      9
Output: 4
Explanation: The longest path has 4 edges (node 3 -> node 8 -> node 5 -> node 6 -> node 9).

#### Constraints :

1 ≤ number of nodes ≤ 10^5
0 ≤ node->data ≤ 10^5



## Related Problems :


### Optimized Solution Complexity

**_Time_** : O(n)
**_Space_** : O(n)