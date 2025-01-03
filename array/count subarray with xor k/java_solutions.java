import java.util.HashMap;

//1 ===================  Using prefix sum   ==========


/*
	//5  ==========  Concept  ======
	1. Xor till i = xor till i-k ^ xor from k to i;
	2. if we are at i and we have total xor as `X`; we know there is someone whose xor is `k` we just need to find if there is someone whose xor is `X ^ k`;

	//5 =========  Complexity  ========
	Time: O(n)
	Space: O(n)

*/

class Solution {
    public long subarrayXor(int[] arr, int k) {
        // Map to store the frequency of XOR values
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case for XOR being 0 initially

        int total = 0; // To store the cumulative XOR
        long count = 0; // To count the subarrays with XOR equal to k

        for (int i : arr) {
            total ^= i; // Update the cumulative XOR

            // Check if there exists a prefix XOR that can form the required XOR
            if (map.containsKey(total ^ k)) {
                count += map.get(total ^ k);
            }

            // Update the frequency of the current XOR value
            map.put(total, map.getOrDefault(total, 0) + 1);
        }

        return count; // Return the count of subarrays
    }
}
