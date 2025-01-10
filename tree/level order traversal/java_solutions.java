import java.util.*;

class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    // Function to return the level order traversal of a tree
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result; // Handle edge case: empty tree

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size(); // Number of nodes at the current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Node node = queue.poll(); // Get the front node
                level.add(node.data);

                if (node.left != null) queue.add(node.left);  // Add left child if it exists
                if (node.right != null) queue.add(node.right); // Add right child if it exists
            }

            result.add(level); // Add the current level to the result
        }

        return result;
    }
}
