#include <bits/stdc++.h>

using namespace std;

//1 =========  Recursion =============

/*
	//5 ==========  Concept ============
	1. for a node result will be left + right answers.
	2. we will pass the max of left, right to upper parent node;

*/

class Node {
public:
    int data;
    Node* left;
    Node* right;

    Node(int val) {
        data = val;
        left = NULL;
        right = NULL;
    }
};

Node* newNode(int val) {
    return new Node(val);
}

class Solution {
  public:
    // Function to return the diameter of a Binary Tree.
    int solve(Node* node, int &result){
        //base case
        if(!node) return 0;
        
        int left = solve(node->left, result);
        int right = solve(node->right, result);
        
        result = max(result, left+right);
        
        return max(left, right) + 1;
        
    }
    int diameter(Node* root) {
        // code here
        int result = INT_MIN;
        
        solve(root, result);
        
        return result;
    }
};