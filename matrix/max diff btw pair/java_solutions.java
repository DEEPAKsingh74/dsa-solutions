


//1 ==============  Using neighbour max =======

/*
	//5 ============  Concept  ==========
	1. We need to find the max value in the matrix for every value of a,b we need to pre compute it.
	2. if we have a=i, b=j we need to find the max of complete matrix from i+1, j+1;
	3. mat[i][j] = max({mat[i][j], mat[i+1][j], mat[i][j+1]}); At every point we need to find max of current, right and down one.

*/


class Solution {
    public int findMaxValue(int[][] mat, int N) {
        int r = mat.length;
        int c = mat[0].length;
        int ans = Integer.MIN_VALUE;

        // Precompute maximum values for the last column
        for (int i = r - 2; i >= 0; i--) {
            mat[i][c - 1] = Math.max(mat[i][c - 1], mat[i + 1][c - 1]);
        }

        // Precompute maximum values for the last row
        for (int i = c - 2; i >= 0; i--) {
            mat[r - 1][i] = Math.max(mat[r - 1][i], mat[r - 1][i + 1]);
        }

        // Traverse the matrix and calculate the maximum value
        for (int i = r - 2; i >= 0; i--) {
            for (int j = c - 2; j >= 0; j--) {
                // Update the maximum value of the submatrix
                ans = Math.max(ans, mat[i + 1][j + 1] - mat[i][j]);
                mat[i][j] = Math.max(mat[i][j], Math.max(mat[i + 1][j], mat[i][j + 1]));
            }
        }

        return ans;
    }

}
