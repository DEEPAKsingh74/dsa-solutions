#include <bits/stdc++.h>

using namespace std;

//1 ======================  basic ======================


/*
	//5 ============= Complexity  =====================
		Time: O(N)
		Space: O(1)
*/

class Solution {
  public:
    void rotate(vector<int> &arr) {
        int element = arr.back();
		arr.pop_back();
		arr.insert(arr.begin(), element);
    }
};


//1 ======================  Swapping ======================


/*
	//5 ============= Complexity  =====================
		Time: O(N)
		Space: O(1)
*/

class Solution {
  public:
    void rotate(vector<int> &arr) {
        int n = arr.size();

		for(int i = n-1; i > 0; i--){
			swap(arr[i], arr[i-1]);
		}
    }
};
