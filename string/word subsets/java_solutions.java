import java.util.*;

//1 ==========  Normally using map  ==========

/*
	//5 =====  Concept=========

	1. Just count the frequency and check if it is subset or not.

*/

class Solution {

    // Helper function to check if the frequency array `wf` is a subset of `freq2`
    private boolean isSubset(int[] wf, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (wf[i] < freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();

        int[] freq2 = new int[26]; // To store the maximum frequency of each letter in words2
        for (String word : words2) {
            int[] wf = new int[26]; // Frequency array for the current word in words2

            for (char l : word.toCharArray()) {
                wf[l - 'a']++;
                freq2[l - 'a'] = Math.max(freq2[l - 'a'], wf[l - 'a']);
            }
        }

        for (String word : words1) {
            int[] wf = new int[26]; // Frequency array for the current word in words1

            for (char ch : word.toCharArray()) {
                wf[ch - 'a']++;
            }

            if (isSubset(wf, freq2)) {
                result.add(word);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "o"};

        List<String> result = solution.wordSubsets(words1, words2);
        System.out.println(result); // Output: [facebook, google, leetcode]
    }
}
