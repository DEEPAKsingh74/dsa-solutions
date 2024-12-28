#include <bits/stdc++.h>

using namespace std;


//1 ======================  Using set  ======================

/*
	//5  ================== Complexity  ===================
		Time: O(N + M)
		Space: O(N + M)
*/



class Solution {
  public:
    // Function to return the count of number of elements in union of two arrays.
    int findUnion(vector<int>& a, vector<int>& b) {
        set<int> st;
        for(auto i : a) st.insert(i);
        for(auto i : b) st.insert(i);
        
        return st.size();
    }


	int findIntersection(vector<int> &a, vector<int> &b){
		map<int, int> mp;
		int count = 0;
		for(auto i : a) mp[i]++;

		for(auto i : b){
			if(mp.find(i) != mp.end()){
				count++;
				if(mp[i] > 1){
					mp[i]--;
				}else{
					mp.erase(i);
				}
			}
		}

		return count;
	}
};