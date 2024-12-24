import java.util.*;

//1 =================== Graph Traversal ===================
/*
    5 ====================  Concept  ==================================

	1. You need to know how to find the diameter of a tree or graph.
	2. find diamter of both tree and find max of:
		a. (d1+1)/2 + (d2+1)/2 + 1  // adding 1 for the edge between the trees that connects them.
		b. d1
		c. d2
*/

class java_solutions {

	// Utility class to represent a pair of values
    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private Pair<Integer, Integer> farthestDistanceNode(List<List<Integer>> adj, int sourceNode, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int maxDistance = 0;
        int lastNode = sourceNode;

        queue.add(sourceNode);
        visited[sourceNode] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int front = queue.poll();
                lastNode = front;

                for (int neighbor : adj.get(front)) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }

            if (!queue.isEmpty()) maxDistance++;
        }

        return new Pair<>(lastNode, maxDistance);
    }

    private int findDiameter(List<List<Integer>> adj, int n) {
        // First traversal where we find the farthest distance node from 0.
        int farthestNode = farthestDistanceNode(adj, 0, n).getKey();

        // Second traversal where we find the farthest node from the diameter one end.
        return farthestDistanceNode(adj, farthestNode, n).getValue();
    }

    private int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return findDiameter(adj, n);
    }

	public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        
		int diameter1 = treeDiameter(edges1);
		int diameter2 = treeDiameter(edges2);

		return Math.max((diameter1 + 1) / 2 + (diameter2 + 1) / 2 + 1, Math.max(diameter1, diameter2));
    }
 
}
