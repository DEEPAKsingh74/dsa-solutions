#include <bits/stdc++.h>
using namespace std;

// 1 =======================  Double loop simple searching  ====================

/*
	5 =====================  Complexity  ===========================

	Time : O(N^2)
	Space : O(1)

 */

class Solution1
{

public:
	bool searchMatrix(vector<vector<int>> &mat, int x)
	{

		for (auto &row : mat)
		{
			for (auto &element : row)
			{
				if (element == x)
					return true;
			}
		}

		return false;
	}
};

// 2 =============================== Binary Search - Method - 1  ====================

/*
	5=============================  Complexity    ===============================

		Time: O(logN + log M)
		Space: O(1)
	5=============================  Concept    ===============================

	1. Traverse the row part only and apply binary search to find where could the value lie in which row.
	2. apply the binary search on that particular row.

*/

class Solution2
{
public:
	// Function to search a given number in row-column sorted matrix.
	bool searchMatrix(vector<vector<int>> &mat, int x)
	{
		int r = mat.size();
		int c = mat[0].size();

		int start = 0;
		int end = r - 1;
		int mid = start;

		while (start <= end)
		{
			mid = start + (end - start) / 2;

			if (x >= mat[mid][0] && x <= mat[mid][c - 1])
			{
				break;
			}

			if (mat[mid][0] < x)
			{
				start = mid + 1;
			}
			else
			{
				end = mid - 1;
			}
		}

		start = 0;
		end = c - 1;
		int ansRow = mid;
		while (start <= end)
		{
			mid = start + (end - start) / 2;

			if (mat[ansRow][mid] == x)
			{
				return true;
			}

			if (mat[ansRow][mid] < x)
			{
				start = mid + 1;
			}
			else
			{
				end = mid - 1;
			}
		}

		return false;
	}
};

// 2 =============================== Binary Search - Method - 2  ====================

/*
	5=============================  Complexity    ===============================

		Time: O(log(N+M))
		Space: O(1)

	5=============================  Concept    ===============================

	1. Assume complete matrix as a single array and apply the binary search.
	2. To find the element from mid :
		a. row = mid / c;
		b. column = mid % c;
*/

class Solution3
{
public:
	bool searchMatrix(vector<vector<int>> &mat, int x)
	{

		int r = mat.size();
		int c = mat[0].size();

		int start = 0;
		int end = r * c - 1;

		while (start <= end)
		{
			int mid = start + (end - start) / 2;

			int midRow = mid / c;
			int midColumn = mid % c;

			if (mat[midRow][midColumn] == x)
				return true;

			if (mat[midRow][midColumn] < x)
			{
				start = mid + 1;
			}
			else
			{
				end = mid - 1;
			}
		}

		return false;
	}
};