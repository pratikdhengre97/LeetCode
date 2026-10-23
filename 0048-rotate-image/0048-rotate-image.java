class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        int[][] rotated = new int[n][n];

        for(int row=0;row<n;row++) {
            for(int col=0;col<n;col++) {
                rotated[col][n-1-row] = matrix[row][col];
            }
        }

        for(int row=0;row<n;row++) {
            for(int col=0;col<n;col++) {
                matrix[row][col] = rotated[row][col];
            }
        }
    }
}