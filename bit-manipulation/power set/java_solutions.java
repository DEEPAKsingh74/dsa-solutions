//1 =============  Using binary forms  ===========

/*
	//5 =======  Concept ===========
	1. take the char only if the corresponding bit is set.
	2. number of elements in ans array will be = (1 << n)

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    // Helper function to extract the subsequence based on the bitmask
    private String findElement(int i, String s) {
        StringBuilder ans = new StringBuilder();
        int idx = s.length() - 1;
        
        while (i > 0) {
            if ((i & 1) == 1) {
                ans.insert(0, s.charAt(idx)); // Insert at the beginning to maintain order
            }
            idx--;
            i = i >> 1; // Right shift to check the next bit
        }
        
        return ans.toString();
    }

    // Main function to generate all possible non-empty subsequences
    public List<String> AllPossibleStrings(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();

        // Iterate through all possible bitmasks (1 to 2^n - 1)
        for (int i = 1; i < (1 << n); i++) {
            ans.add(findElement(i, s));
        }

        // Sort the list lexicographically
        Collections.sort(ans);

        return ans;
    }
}