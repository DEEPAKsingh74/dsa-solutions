#include <bits/stdc++.h>

using namespace std;

//1 ================ Using swaping variables  ===========

/*
	//5  ================ Concept =========
	1. multiple maxp and minp with arr[i] and find min and max of arr[i] and arr[i]*maxp or arr[i]*minp.
	2. if there is a negative value swap maxp and minp.

	//5  ================ Complexity =========
	Time: O(n)
	Space: O(1)

*/


class Solution {
  public:
    // Function to find maximum product subarray
    int maxProduct(vector<int> &arr) {
        int maxp = 1;
        int minp = 1;
        int ans= INT_MIN;
        int n = arr.size();
        for(int i = 0; i < n; i++){
            if(arr[i] < 0) {
                swap(maxp, minp);
            }
            maxp = max(arr[i], arr[i]*maxp);
            minp = min(arr[i], arr[i]*minp);
            
            ans = max({ans, maxp, minp});
        }
        
        return ans;
    }
};


//2 ================ Using prefix suffix product  ===========

/*
	//5  ================ Concept =========
	1. find the prefix and suffix products where they get 0 make them 1 again and continue.

	//5  ================ Complexity =========
	Time: O(n)
	Space: O(1)

*/



class Solution {
  public:
    // Function to find maximum product subarray
    int maxProduct(vector<int> &arr) {
        int prefix_p = 1;
        int suffix_p = 1;
        int ans = INT_MIN;
        int n = arr.size();
        for(int i = 0; i < n; i++){
            if(prefix_p == 0) prefix_p = 1;
            if(suffix_p == 0) suffix_p = 1;
            prefix_p *= arr[i];
            suffix_p *= arr[n-i-1];
            ans = max({ans, prefix_p, suffix_p});
        }
        
        return ans;
    }
};