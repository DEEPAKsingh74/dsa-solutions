import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1 ===================== Using loop ========================

/*
    //5 ======================= Concept =======================
        1. Using three loops to find all the triplets.

    //5 ======================= Complexity =======================
        time: O(N^3)
        space: O(1)
*/

class Solution {
    public List<List<Integer>> findTripletsUsingLoop(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        ans.add(List.of(i, j, k));
                    }
                }
            }
        }

        return ans;
    }
}

// 2 ===================== Using Target sum approach ========================

/*
    //5 ======================= Concept =======================
        1. Use an i loop for traversal and apply the target sum to the subarray(i+1, n);

    //5 ======================= Complexity =======================
        time: O(N^2)
        space: O(N^2)
*/

class SolutionWithTargetSum {
    public List<List<Integer>> findTriplets(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            int target = -arr[i];

            for (int j = i + 1; j < n; j++) {
                int complement = target - arr[j];

                if (map.containsKey(complement)) {
                    for (int k : map.get(complement)) {
                        ans.add(List.of(i, k, j));
                    }
                }

                map.computeIfAbsent(arr[j], key -> new ArrayList<>()).add(j);
            }
        }

        return ans;
    }
}

