
//1 =========  Recursion =============

/*
	//5 ==========  Concept ============
	1. for a node result will be left + right answers.
	2. we will pass the max of left, right to upper parent node;

*/

class Node {
    int data;
    Node left;
    Node right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

// Solution class definition
class Solution {
    // Function to return the diameter of a Binary Tree
    public int diameter(Node root) {
        // Use an array to simulate pass-by-reference for the result
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE; // Initialize result to the smallest possible value

        // Call the solve function
        solve(root, result);

        // Return the computed diameter
        return result[0];
    }

    // Helper function to compute diameter recursively
    private int solve(Node node, int[] result) {
        // Base case: if the node is null, return 0
        if (node == null) {
            return 0;
        }

        // Recursively compute the height of the left and right subtrees
        int left = solve(node.left, result);
        int right = solve(node.right, result);

        // Update the result with the maximum diameter found so far
        result[0] = Math.max(result[0], left + right);

        // Return the height of the current node
        return Math.max(left, right) + 1;
    }
}
