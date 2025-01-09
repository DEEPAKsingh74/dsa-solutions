#include <bits/stdc++.h>
using namespace std;

//1 =============  Using binary forms  ===========

/*
	//5 =======  Concept ===========
	1. take the char only if the corresponding bit is set.
	2. number of elements in ans array will be = (1 << n)

*/

class Solution{
	public:
	
	    string findElement(int i, string s){
	        string ans = "";
	        int idx = s.size()-1;
	        while(i > 0){
	            if(i & 1){
	                ans = s[idx] + ans;
	            }
	            idx--;
	            i = i >> 1;
	        }
	        
	        return ans;
	    }
	
		vector<string> AllPossibleStrings(string s){
		    vector<string> ans;
		    
		    int n = s.size();
		    
		    for(int i = 1; i < (1<<n); i++){
		        ans.push_back(findElement(i, s));
		    }
		    
		    sort(ans.begin(), ans.end());
		    
		    return ans;
		}
};