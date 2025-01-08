#include <bits/stdc++.h>

using namespace std;

//1 ==============  Using 3 pointers approach  ==============


/*
	//5 ==== Concept 
	1. keep three pointers at start of each array and as the arr are sorted move the pointers with smallest value when all three values dont match.
	2. handle duplicates also.

	//5 =======  complexity
	Time: O(n)
	space: O(n)

*/



class Solution {
  public:
    // Function to find common elements in three arrays.
    vector<int> commonElements(vector<int> &arr1, vector<int> &arr2,
                               vector<int> &arr3) {
        vector<int> ans;
        
        int i = 0, j = 0, k = 0;
        int ni = arr1.size(), nj = arr2.size(), nk = arr3.size();
        while(i < ni && j < nj && k < nk){
            if(arr1[i] == arr2[j] && arr1[i] == arr3[k] && (ans.empty() || ans.back() != arr1[i])){
                ans.push_back(arr1[i]);
                i++;
                j++;
                k++;
            }else{
                int mini = min({arr1[i], arr2[j], arr3[k]});
                if(arr1[i] == mini) i++;
                else if (arr2[j] == mini) j++;
                else k++;
            }
        }
        
        return ans;
    }
};



//1 ==============  Using Map(If they are not given as sorted)  ==============


/*
	//5 ==== Concept 
	1. map keeps track of {element, {count, last_row_seen}}.
    2. If the element has last_row_seen same we will not update the count else we will update.

	//5 =======  complexity
	Time: O(n*m)
	space: O(n)

*/


class Solution {
  public:
    // Function to find common elements in three arrays.
    vector<int> commonElements(vector<int> &arr1, vector<int> &arr2,
                               vector<int> &arr3) {
        vector<int> ans;
        map<int, pair<int, int>> mp;  // {element, {count, last_row_seen}}

        for(int i = 0; i < arr1.size(); i++){
            if(mp.find(arr1[i]) != mp.end()){
                if(mp[arr1[1]].second == 0){
                    continue;
                }
            }

            mp[arr1[i]] = {mp[arr1[i]].first + 1, 0};
        }
        for(int i = 0; i < arr2.size(); i++){
            if(mp.find(arr2[i]) != mp.end()){
                if(mp[arr2[1]].second == 1){
                    continue;
                }
            }

            mp[arr1[i]] = {mp[arr1[i]].first + 1, 1};
        }
        for(int i = 0; i < arr3.size(); i++){
            if(mp.find(arr3[i]) != mp.end()){
                if(mp[arr3[1]].second == 2){
                    continue;
                }
            }

            mp[arr1[i]] = {mp[arr1[i]].first + 1, 2};
        }

        for(auto i : mp){
            if(i.second.first == 3) ans.push_back(i.first);
        }
        
        
        return ans;
    }
};