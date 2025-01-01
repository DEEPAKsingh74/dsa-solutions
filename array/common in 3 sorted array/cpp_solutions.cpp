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