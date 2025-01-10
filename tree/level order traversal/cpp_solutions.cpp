#include <bits/stdc++.h>

using namespace std;

//1 ======== Using queue =========



class Node {
  public:
    int data;
    Node* left;
    Node* right;

    // Constructor
    Node(int val) {
        data = val;
        left = nullptr;
        right = nullptr;
    }
};



class Solution {
  public:
    // Function to return the level order traversal of a tree.
    vector<vector<int>> levelOrder(Node *root) {
        
        queue<Node*> q;
        q.push(root);
        vector<vector<int>> ans;
        
        while(!q.empty()){
            int n = q.size();
            vector<int> temp;
            while(n--){
                Node* f = q.front();
                q.pop();
                
                temp.push_back(f->data);
                
                if(f->left) q.push(f->left);
                if(f->right) q.push(f->right);
            }
            
            ans.push_back(temp);
        }
        
        return ans;
    }
};