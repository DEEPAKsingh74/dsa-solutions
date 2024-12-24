import java.util.*;

//1 =================== Graph Traversal ===================
/*
    5============================= Concept ===========================

    1. If we find the farthest end from any random node it will be one of the end of the diameter.
    2. If we find the farthest point from one end of diameter it will be the other end of diameter.
    3. Combine both we got our answers.
*/

class java_solutions {

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

    public int treeDiameter(int[][] edges) {
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
}
