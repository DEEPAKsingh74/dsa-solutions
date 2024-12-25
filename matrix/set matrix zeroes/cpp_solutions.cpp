#include <bits/stdc++.h>

using namespace std;

//1 ==========================  Using external matrix ==============

/*
	//5 =====================  Concept   ==================================
	1. Take another matrix and transform in any of the matrix by looking in other matrix.
	
	//5 =====================  Complexity   ==================================

	Time: O(N^2)
	Space: O(N^2)

*/

class Solution1 {
  public:
    void setMatrixZeroes(vector<vector<int>> &mat) {

		int r = mat.size();
		int c = mat[0].size();

		// copy the matrix into another temp matrix.
		vector<vector<int>> temp(begin(mat), end(mat));

		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				if(mat[i][j] == 0){
					temp[i][0] = 0;
					temp[0][j] = 0;
				}
			}
		}

		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				if(temp[i][0] == 0 || temp[0][j] == 0){
					mat[i][j] = 0;
				}
			}
		}
	}
};


//2 ==========================  Using single row and column array ==============

/*
	//5 =====================  Concept   ==================================
	1. We actually dont need complete matrix just the single row and single column will do the same thing.
	
	//5 =====================  Complexity   ==================================

	Time: O(N^2)
	Space: O(2N)

*/


class Solution2 {
  public:
    void setMatrixZeroes(vector<vector<int>> &mat) {

		int r = mat.size();
		int c = mat[0].size();

		// copy the matrix into another temp matrix.
		vector<int> row(r, -1);
		vector<int> col(c, -1);

		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				if(mat[i][j] == 0){
					row[i] = 0;
					col[j] = 0;
				}
			}
		}

		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				if(row[i] == 0 || col[j] == 0){
					mat[i][j] = 0;
				}
			}
		}
	}
};

//3 ==========================  Using the matrix first row and column ==============

/*
	//5 =====================  Concept   ==================================
	1. Take the first row and column as the state for holding which row and column would be transformed.
	2. additionally take a var to store the state for first row.
	
	//5 =====================  Complexity   ==================================

	Time: O(N^2)
	Space: O(1)

*/


class Solution3 {
  public:
    void setMatrixZeroes(vector<vector<int>> &mat) {
        // code here
        int r = mat.size();
        int c = mat[0].size();
        int col0 = 1;
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(mat[i][j] == 0){
                    if(j == 0){
                        col0 = 0;
                    }else{
                        mat[i][0] = 0;
                        mat[0][j] = 0;
                    }
                }
            }
        }
        
        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                if(mat[i][0] == 0 || mat[0][j] == 0){
                    mat[i][j] = 0;
                }
            }
        }
        
        if(mat[0][0] == 0){
            for(int i = 0; i < c; i++){
                mat[0][i] = 0;
            }
        }
        
        if(col0 == 0){
            for(int i = 0; i < r; i++){
                mat[i][0] = 0;
            }
        }
    }
};