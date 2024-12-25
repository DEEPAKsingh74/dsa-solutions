import java.util.*;

// 1 ====================== BFS traversal  ======================

/*
	//5 ====================  Concept  =======================

	1. Traverse each row using bfs and find the max in each row/level.

	//5 ====================  Complexity  =======================
		Time : O(N)
		Space: O(N)

 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		this.left = null;
		this.right = null;
	}
}

class Solution {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				max = Math.max(max, node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			res.add(max);
		}
		return res;
	}
}