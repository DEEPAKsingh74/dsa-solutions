//1 =====================  Using another array ====================

/*
	//5 ========================== Concept  =========================

	1. Take another array as a helper and insert all elements into it in reverse order and return.

	//5 ========================== Complexity  =========================

		Time: o(N)
		Space: O(N)
*/

class Solution {
	public void reverseArr(int[] arr){
		int n = arr.length;
		int temp[] = new int[n];

		for(int i = 0; i < n; i++){
			temp[i] = arr[n-i-1];
		}

		for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
	}
}


//2 =====================  Using Recursion ====================

/*
	//5 ========================== Concept  =========================

	1. Recursive find the solution when we back track put the element at the end.

	//5 ========================== Complexity  =========================

		Time: o(N)
		Space: O(N)
*/

class Solution2 {
	public void reverseArr(int[] arr, int i){
		if(arr.length == i) return;

		int element = arr[i];
		reverseArr(arr, i+1);

		arr[arr.length - i - 1] = element;
		
	}
}