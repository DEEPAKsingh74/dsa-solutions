#include <bits/stdc++.h>

using namespace std;

//2 =======================  Using Sorting =====================

/*
	//5 ==================  Concept  =======================
		1. Sort

	//5 =================  Complexity  ====================

	Time: o(Nlog(N))
	space: O(1)

*/


class Solution {
	public:
    void sort012(vector<int>& arr) {
		sort(arr.begin(), arr.end());
	}
};

//2 =======================  Using counting =====================

/*
	//5 ==================  Concept  =======================
		1. Count the number of 0 and 1 and 2 and just replace them in the arr.

	//5 =================  Complexity  ====================

	Time: o(N)
	space: O(1)

*/


class Solution {
	public:
    void sort012(vector<int>& arr) {
		int count_0 = 0;
		int count_1 = 0;
		int count_2 = 0;

		for(auto i : arr){
			if(i == 0) count_0++;
			if(i == 1) count_1++;
			if(i == 2) count_2++;
		}

		for(int i = 0; i < arr.size(); i++){
			if(count_0 > 0){
				arr[i] = 0;
				count_0--;
			}else if(count_1 > 0){
				arr[i] = 1;
				count_1--;
			}else{
				arr[i] = 2;
				count_2--;
			}
		}
    }
};



//3 =======================  Using Dutch national Flag Algorithm =====================

/*
	//5 ==================  Concept  =======================
		1. Take three pointers low, mid, high.
		2. move mid and swap such that 0 appears at start and 2 appears at end 1 will auto adjust.

	//5 =================  Complexity  ====================

	Time: o(N)
	space: O(1)

*/


class Solution {

	public:
	void sort012(vector<int>& arr) {
		int low = 0;
		int n = arr.size();
		int mid = 0;
		int high = n-1;

		while(mid <= high){
			if(arr[mid] == 0){
				swap(arr[low++], arr[mid++]);
			}else if(arr[mid] == 1){
				mid++;
			}else{
				swap(arr[mid], arr[high--]);
			}
		}

    }
};