import java.util.*;

// 1 ========================= Using Sorting ==================

/*
    // 5 ============================== Concept =====================
        1. Sort and return the k-1 element.

    // 5 ============================== Complexity =====================
        Time: O(Nlog(N))
        Space: O(1)
*/

class Solution {
    public Pair<Integer, Integer> kthSmallestLargest(List<Integer> arr, int k) {
        Collections.sort(arr);

        return new Pair<>(arr.get(k - 1), arr.get(arr.size() - k));
    }
}

// 2 ========================= Using Heap ==================

/*
    // 5 ============================== Concept =====================
        1. Insert in a heap and one by one pop and return the kth element.

    // 5 ============================== Complexity =====================
        Time: O(Nlog(K))
        Space: O(2N)
*/

class Solution2 {
    public Pair<Integer, Integer> kthSmallestLargest(List<Integer> arr, int k) {
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : arr) {
            minH.add(i);
            maxH.add(i);
        }

        for (int i = 0; i < k - 1; i++) {
            minH.poll();
            maxH.poll();
        }

        return new Pair<>(minH.peek(), maxH.peek());
    }
}

// 3 ========================= Using Quick Select ==================

/*
    // 5 ============================== Concept =====================
        1. arr[] = {1, 5, 4, 6, 7}
        2. Apply modified quick sort algorithm. Choose a pivot and place elements before and after the pivot.
        3. arr[] = {1, || 4, || 5, 6, 7}. If we need the kth largest, move to the right partition and apply the same.

    // 5 ============================== Complexity =====================
        Time: O(N)
        Space: O(N)
*/

class Solution3 {
    // Quick select method
    private int quickSelect(List<Integer> arr, int k) {
        Random rand = new Random();
        int pivotIdx = rand.nextInt(arr.size());

        int pivot = arr.get(pivotIdx);

        List<Integer> leftArr = new ArrayList<>();
        List<Integer> midArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();

        for (int val : arr) {
            if (val > pivot) {
                leftArr.add(val);
            } else if (val < pivot) {
                rightArr.add(val);
            } else {
                midArr.add(val);
            }
        }

        if (k <= leftArr.size()) {
            return quickSelect(leftArr, k);
        }
        if (leftArr.size() + midArr.size() < k) {
            return quickSelect(rightArr, k - leftArr.size() - midArr.size());
        }

        return pivot;
    }

    // Find kth largest
    private int KthLargest(List<Integer> arr, int k) {
        return quickSelect(arr, k);
    }

    // Public method to return both kth smallest and kth largest
    public Pair<Integer, Integer> kthSmallestLargest(List<Integer> arr, int k) {
        if (arr.size() < k)
            return new Pair<>(-1, -1);

        return new Pair<>(KthLargest(arr, arr.size() - k + 1), KthLargest(arr, k));
    }
}

// Pair class for returning both values from kthSmallestLargest method
class Pair<T, U> {
    public T first;
    public U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first + " : " + second;
    }
}

