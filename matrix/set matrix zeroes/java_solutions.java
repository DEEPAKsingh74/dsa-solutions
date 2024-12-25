import java.util.*;

//1 ==========================  Using external matrix ==============

/*
	//5 =====================  Concept   ==================================
	1. Take another matrix and transform in any of the matrix by looking in other matrix.
	
	//5 =====================  Complexity   ==================================

	Time: O(N^2)
	Space: O(N^2)

*/

class Solution1 {
    public void setMatrixZeroes(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        // Create a temporary matrix and copy the contents of the input matrix
        int[][] temp = new int[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(mat[i], 0, temp[i], 0, c);
        }

        // Mark rows and columns in temp based on zeros in mat
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0) {
                    temp[i][0] = 0;
                    temp[0][j] = 0;
                }
            }
        }

        // Update mat based on temp
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (temp[i][0] == 0 || temp[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
    }
}



//2 ==========================  Using single row and column array ==============

/*
	//5 =====================  Concept   ==================================
	1. We actually dont need complete matrix just the single row and single column will do the same thing.
	
	//5 =====================  Complexity   ==================================

	Time: O(N^2)
	Space: O(2N)

*/


class Solution2 {
    public void setMatrixZeroes(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        // Arrays to store row and column states
        int[] row = new int[r];
        int[] col = new int[c];
        Arrays.fill(row, -1);
        Arrays.fill(col, -1);

        // Mark rows and columns based on zeros in mat
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }

        // Update mat based on row and col arrays
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (row[i] == 0 || col[j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
    }
}


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
    public void setMatrixZeroes(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        boolean col0 = true;

        // Use the first row and column as markers
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0) {
                    if (j == 0) {
                        col0 = false;
                    } else {
                        mat[i][0] = 0;
                        mat[0][j] = 0;
                    }
                }
            }
        }

        // Update the matrix based on the markers
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // Handle the first row
        if (mat[0][0] == 0) {
            for (int i = 0; i < c; i++) {
                mat[0][i] = 0;
            }
        }

        // Handle the first column
        if (!col0) {
            for (int i = 0; i < r; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
