#include <bits/stdc++.h>
using namespace std;

//1 =====================  Using another array ====================

/*
	//5 ========================== Concept  =========================

	1. Take another array as a helper and insert all elements into it in reverse order and return.

	//5 ========================== Complexity  =========================

		Time: o(N)
		Space: O(N)
*/


class Solution {

	public:
	void reverseArr(vector<int> &arr){
		int n = arr.size();
		vector<int> temp(n);
		for(int i = 0; i < n; i++){
			temp[i] = arr[n-i-1];
		}
		
		arr = temp;
	}
};

//2 =====================  Using Recursion ====================

/*
	//5 ========================== Concept  =========================

	1. Recursive find the solution when we back track put the element at the end.

	//5 ========================== Complexity  =========================

		Time: o(N)
		Space: O(N)
*/


class Solution {

	public:
	void reverseArr(vector<int> &arr, int i = 0){

		//base case
		if(arr.size() == i) return;

		int element = arr[i];
		reverseArr(arr, i+1);

		arr[arr.size() - i - 1] = element;
	}
};


//3 =====================  Using Two pointer approach ====================

/*
	//5 ========================== Concept  =========================

	1. Take 2 pointers and at start and end and reverse till the mid only if we extend after mid it will revese two times reaching to original array only.

	//5 ========================== Complexity  =========================

		Time: o(N)
		Space: O(1)
*/


class Solution {

	public:
	void reverseArr(vector<int> &arr){
		int n = arr.size();
		for(int i = 0; i < n/2; i++){
			swap(arr[i], arr[n-i-1]);
		}
	}
};
