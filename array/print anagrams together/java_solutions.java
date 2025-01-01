import java.util.*;

class Solution {

    // 1. Using Sorting
    /*
        Concept:
        - Sort each string to generate a hash. All anagrams will have the same sorted string, 
          which can be used as the key in a hashmap to group them.
    */
    public List<List<String>> groupAnagramsUsingSorting(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : arr) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars); // Sort characters
            String sortedStr = new String(chars); // Convert back to string
            
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str); // Group by sorted string
        }
        
        return new ArrayList<>(map.values());
    }

    // 2. Using Custom Prime Number Hash
    /*
        Concept:
        - Assign a unique prime number to each character ('a' -> 2, 'b' -> 3, ..., 'z' -> 101).
        - Compute a hash for each string by multiplying these primes. Since prime factorization is unique,
          all anagrams will result in the same hash.
    */
    public List<List<String>> groupAnagramsUsingPrimes(String[] arr) {
        int[] primeMapping = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47,
            53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
        }; // Prime numbers for 'a' to 'z'

        Map<Long, List<String>> map = new HashMap<>();
        
        for (String str : arr) {
            long hash = 1; // Use long to avoid overflow
            for (char c : str.toCharArray()) {
                hash *= primeMapping[c - 'a'];
            }
            
            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(str); // Group by prime product hash
        }
        
        return new ArrayList<>(map.values());
    }
}
