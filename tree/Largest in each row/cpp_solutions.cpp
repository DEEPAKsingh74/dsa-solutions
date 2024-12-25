#include <bits/stdc++.h>

using namespace std;

// 1 ====================== BFS traversal  ======================

/*
	//5 ====================  Concept  =======================

	1. Traverse each row using bfs and find the max in each row/level.

	//5 ====================  Complexity  =======================
		Time : O(N)
		Space: O(N)

 */

class TreeNode
{

public:
	int val;
	TreeNode *left;
	TreeNode *right;

	TreeNode(int value){
		this->val = value;
		this->left = NULL;
		this->right = NULL;
	}
};

class Solution
{

public:
	vector<int> largestValues(TreeNode *root)
	{
		queue<TreeNode *> q;
		q.push(root);
		vector<int> ans;

		if (root == NULL)
			return ans;
		while (!q.empty())
		{
			int n = q.size();
			int maxi = INT_MIN;
			while (n--)
			{
				TreeNode *front = q.front();
				q.pop();
				maxi = max(maxi, front->val);

				if (front->left)
					q.push(front->left);
				if (front->right)
					q.push(front->right);
			}

			ans.push_back(maxi);
		}

		return ans;
	}
};