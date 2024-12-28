#include <bits/stdc++.h>
using namespace std;

//1 ======================  Using sorting ====================

/*

	//5 ================  Complexity  ====================

		Time: O(Nlog(N))
		Space: O(1)

*/


class Solution {
	public:
		void separateNegPos(vector<int> &arr){
			sort(arr.begin(), arr.end());
		}
};

//2 ======================  Using 2 pointers ====================

/*
	//5 =============== Concept  =======================
	1. Use 2 pointers one for negative and other positive, when we get swap when we get negative for larger pointer and positive for smaller pointer.

	//5 ================  Complexity  ====================

		Time: O(N)
		Space: O(1)

*/


class Solution2 {
	public:
		void separateNegPos(vector<int> &arr){
			int low = 0;
			int high = arr.size()-1;

			while(low <= high){
				if(arr[low] < 0) low++;
				else if(arr[high] >= 0) high--;
				else if(arr[low] >= 0 && arr[high] < 0){
					swap(arr[low++], arr[high--]);
				}
			}
		}
};