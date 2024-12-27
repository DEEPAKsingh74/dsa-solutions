#include <bits/stdc++.h>

using namespace std;

// 1 =========================  USing Sorting  ==================

/*
	//5 ============================== Concept  =====================

		1. Sort and return the k-1 element.

	//5 ============================== Ccomplexity  =====================
		Time: O(Nlog(N))
		Space: O(1)
*/

class Solution
{
public:
	pair<int, int> kthSmallestLargest(vector<int> &arr, int k)
	{
		sort(arr.begin(), arr.end());

		return {arr[k - 1], arr[arr.size() - k]};
	}
};

// 2 =========================  USing  Heap  ==================

/*
	//5 ============================== Concept  =====================

		1. Insert in a heap and one by one pop and return the kth element.

	//5 ============================== Ccomplexity  =====================
		Time: O(Nlog(K))
		Space: O(2N)
*/

class Solution
{

public:
	pair<int, int> kthSmallestLargest(vector<int> &arr, int k)
	{
		priority_queue<int, vector<int>, greater<int>> minH;
		// We can use single priority also totally depends.
		priority_queue<int> maxH;

		for (auto i : arr)
		{
			minH.push(i);
			maxH.push(i);
		}

		for (int i = 0; i < k - 1; i++)
		{
			minH.pop();
			maxH.pop();
		}

		return {minH.top(), maxH.top()};
	}
};

// 2 =========================  USing  Quick select  ==================

/*
	//5 ============================== Concept  =====================

		1. arr[] = {1, 5, 4, 6, 7}
		2. Apply modified quick sort algorithm. choose a pivot and place elements before and after of the pivot lets take pivot as 4.
		3. arr[] = {1, || 4, || 5, 6, 7} if we need third largest move to the right partition and apply same.


	//5 ============================== Ccomplexity  =====================

*/

class Solution
{
	int quickSelect(vector<int> &arr, int k)
	{

		int pivotIdx = rand() % arr.size();

		int pivot = arr[pivotIdx];

		vector<int> leftArr;

		vector<int> midArr;

		vector<int> rightArr;

		for (int val : arr)
		{
			if (val > pivot)
			{
				leftArr.push_back(val);
			}
			else if (val < pivot)
			{
				rightArr.push_back(val);
			}
			else
			{
				midArr.push_back(val);
			}
		}

		if (k <= leftArr.size())
		{

			return quickSelect(leftArr, k);
		}
		if (leftArr.size() + midArr.size() < k)
		{

			return quickSelect(rightArr, k - leftArr.size() - midArr.size());
		}

		return pivot;
	}

	int KthLargest(vector<int> &arr, int k)
	{

		return quickSelect(arr, k);
	}

public:
	pair<int, int> kthLargestSmallest(vector<int> arr, int k)
	{
		if (arr.size() < k)
			return {-1, -1};

		return {KthLargest(arr, arr.size() - k + 1), KthLargest(arr, k), };
	}
};