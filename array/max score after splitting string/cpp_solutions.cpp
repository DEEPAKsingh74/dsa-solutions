#include <bits/stdc++.h>

using namespace std;

//1 ==================  Using Extra Space  ==============

/*
	//5  ===========  Concept   =============
	1. at every point we should know how many 0 and 1 we have.

	//5  =============  Complexity  =========

	Time: O(N^2)
	Space: O(1)

*/

class Solution {
public:
    int maxScore(string s) {
		int ans = 0;
		for(int i = 0; i < s.size()-1; i++){
			int z_count = 0, o_count = 0;
			for(int j = 0; j <= i; j++){
				if(s[j] == '0') z_count++;
			}
			for(int j = i+1; j < s.size(); j++){
				if(s[j] == '1') o_count++;
			}
			ans = max(ans, o_count+z_count);
		}

		return ans;
    }
};

//1 ==================  Using Count of 0 and 1  ==============

/*
	//5  ===========  Concept   =============
	1. Store count of 1.
	2. loop through if we encounter 0 increment zer count if we encounter one decrement its count.

	//5  =============  Complexity  =========

	Time: O(N)
	Space: O(1)

*/

class Solution {
public:
    int maxScore(string s) {
        int one_count = 0, zero_count = 0;
        int ans = 0;
        for(auto i : s){
            if(i == '1') one_count++;
        }
        for(int i = 0; i < s.size()-1; i++){
            if(s[i] == '0') zero_count++;
            else one_count--;
            ans = max(ans, one_count + zero_count);
        }
        return ans;
    }
};