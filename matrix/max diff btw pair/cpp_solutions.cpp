#include <bits/stdc++.h>

using namespace std;

//1 ==============  Using neighbour max =======

/*
	//5 ============  Concept  ==========
	1. We need to find the max value in the matrix for every value of a,b we need to pre compute it.
	2. if we have a=i, b=j we need to find the max of complete matrix from i+1, j+1;
	3. mat[i][j] = max({mat[i][j], mat[i+1][j], mat[i][j+1]}); At every point we need to find max of current, right and down one.

*/

class Solution {
public:
    int findMaxValue(vector<vector<int>>&mat, int N)
    {
        int r = mat.size();
        int c = mat[0].size();
        int ans = INT_MIN;
        
        for(int i = r-2; i >= 0; i--){
            mat[i][c-1] = max(mat[i][c-1], mat[i+1][c-1]);
        }
        for(int i = c-2; i >= 0; i--){
            mat[r-1][i] = max(mat[r-1][i], mat[r-1][i+1]);
        }
        
        for(int i = r-2; i >=0; i--){
            for(int j = c-2; j >= 0; j--){
                ans = max(ans, mat[i+1][j+1] - mat[i][j]);
                mat[i][j] = max({mat[i][j], mat[i+1][j], mat[i][j+1]});
            }
        }
        
        return ans;
    }
};