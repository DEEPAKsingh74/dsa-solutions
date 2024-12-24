# Links:

- [Leetcode](https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/description)

# Problem Statement :

There exist two undirected trees with n and m nodes, numbered from 0 to n - 1 and from 0 to m - 1, respectively. You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree.

You must connect one node from the first tree with another node from the second tree with an edge.

Return the minimum possible diameter of the resulting tree.

The diameter of a tree is the length of the longest path between any two nodes in the tree.


#### Examples :

Input: edges1 = \[[0,1],[0,2],[0,3]], edges2 = \[[0,1]]

Output: 3

Input: edges1 = \[[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]], edges2 = \[[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]

Output: 5


## Related Problems :


### Optimized Solution Complexity

**_Time_** : - O(V + E)
**_Space_** : - O(V + E) + O(N)