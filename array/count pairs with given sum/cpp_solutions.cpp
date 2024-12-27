#include <bits/stdc++.h>

using namespace std;

//1 ============================ Using Nested Loop  =========================

/*
	//5 ==========================  Concept ========================
		1. Traverse the array 2 nested for loops but start the inner always after the outer index and match with the target.

	//5 ==========================  Complexity  ========================
		Time: O(N^2)
		Space: O(1)

*/


class Solution {
	public:
    int countPairs(vector<int> &arr, int target) {
		int n = arr.size();
		int count = 0;

		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				if(arr[i] + arr[j] == target){
					count++;
				}
			}
		}
		return count;
	}
};

//2 ============================ Using Map  =========================

/*
	//5 ==========================  Concept ========================
		1. Store the values found in a value with their count.
		2. Traverse and find if (target - arr[i]) already present if yes increment count by value of (target - arr[i]).

	//5 ==========================  Complexity  ========================
		Time: O(N)
		Space: O(N)

*/


class Solution {
	public:
    int countPairs(vector<int> &arr, int target) {
        map<int, int> mp;
        int n = arr.size();
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(mp.find(target - arr[i]) != mp.end()){
                count += mp[target - arr[i]];
            }
            mp[arr[i]]++;
            
        }
        
        return count;
        
    }
};