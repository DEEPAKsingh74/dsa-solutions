#include <bits/stdc++.h>

using namespace std;

//1 =====================  USing loop  ========================

/*
	//5 =======================  Concept  =======================
		1. Using three loops and find all the triplets.

	//5 =======================  complexity  =======================
		time: O(N^3)
		space: O(1)

*/

class Solution {
	public:
    vector<vector<int>> findTriplets(vector<int> &arr) {
		int n = arr.size();
		vector<vector<int>> ans;

		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				for(int k = j+1; k < n; k++){
					if(arr[i] + arr[j] + arr[k] == 0){
						ans.push_back({i, j, k});
					}
				}
			}
		}

		return ans;
	}
};


//2 =====================  USing Target sum approach  ========================

/*
	//5 =======================  Concept  =======================
		1. Use a i loop for traversal and apply the target sum to the subarray(i+1, n);

	//5 =======================  complexity  =======================
		time: O(N^2)
		space: O(N^2)

*/

class Solution {
  public:
    vector<vector<int>> findTriplets(vector<int> &arr) {
        int n = arr.size();
        vector<vector<int>> ans;
        for(int i = 0; i < n; i++){
            map<int, vector<int>> mp;
            int target = -arr[i];
            for(int j = i+1; j < n; j++){
                if(mp.find(target - arr[j]) != mp.end()){
                    for(auto k : mp[target-arr[j]]){
                        ans.push_back({i, k, j});
                    }
                }
                
                mp[arr[j]].push_back(j);
            }
        }
        
        return ans;
    }
};