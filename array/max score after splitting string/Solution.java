
public class Solution {

    //1 Using Extra Space
    /*
        Concept:
        1. At every point, we should know how many 0s and 1s we have.

        Complexity:
        Time: O(N^2)
        Space: O(1)
    */
    public int maxScoreExtraSpace(String s) {
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int zeroCount = 0, oneCount = 0;

            // Count 0s in the left part
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') zeroCount++;
            }

            // Count 1s in the right part
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == '1') oneCount++;
            }

            // Update the max score
            ans = Math.max(ans, zeroCount + oneCount);
        }

        return ans;
    }

    //2 Using Count of 0 and 1
    /*
        Concept:
        1. Store the count of 1s in the entire string.
        2. Loop through the string: if we encounter '0', increment zeroCount; if we encounter '1', decrement oneCount.

        Complexity:
        Time: O(N)
        Space: O(1)
    */
    public int maxScore(String s) {
        int oneCount = 0, zeroCount = 0, ans = 0;

        // Count total 1s in the string
        for (char c : s.toCharArray()) {
            if (c == '1') oneCount++;
        }

        // Iterate through the string and calculate the maximum score
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
            } else {
                oneCount--;
            }
            ans = Math.max(ans, zeroCount + oneCount);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        String s = "011101";
        System.out.println("Using Extra Space: " + sol.maxScoreExtraSpace(s)); // Output: 5
        System.out.println("Using Optimized Approach: " + sol.maxScore(s));   // Output: 5
    }
}

