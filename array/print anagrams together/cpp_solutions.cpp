#include <bits/stdc++.h>

using namespace std;


//1  ==============  USing sorting  =============

/*
	//5  ==========  Concept  ========
	1. anagrams which are sorted are equal using this concept we can store them in a hashmap as a hash

	//5 ======== Complexity  ===========
	Time: o(n*m log(m))
	space: O(n)

*/

class Solution {
public:
    vector<vector<string>> anagrams(vector<string>& arr) {
        unordered_map<string, vector<string>> mp;
        for (auto& str : arr) {
            string sortedStr = str;
            sort(sortedStr.begin(), sortedStr.end()); // Sort characters
            mp[sortedStr].push_back(str);            // Group by sorted string
        }

        vector<vector<string>> ans;
        for (auto& pair : mp) {
            ans.push_back(pair.second); // Collect grouped anagrams
        }
        return ans;
    }
};


//2  ==============  USing Custom prime number hash  =============

/*
	//5  ==========  Concept  ========
	1. main logic is we need to generate hash for each anagrams that are equal so that we can classify them equal.

	//5 ======== Complexity  ===========
	Time: o(n*m)
	space: O(n)

*/


class Solution {
public:
    vector<vector<string>> anagrams(vector<string>& arr) {
        vector<int> primeMapping = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 
            53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
        }; // Prime numbers for 'a' to 'z'
        
        unordered_map<long long, vector<string>> mp;
        for (auto& str : arr) {
            long long hash = 1; // Use long long to avoid overflow
            for (char c : str) {
                hash *= primeMapping[c - 'a'];
            }
            mp[hash].push_back(str); // Group by prime product hash
        }

        vector<vector<string>> ans;
        for (auto& pair : mp) {
            ans.push_back(pair.second); // Collect grouped anagrams
        }
        return ans;
    }
};
