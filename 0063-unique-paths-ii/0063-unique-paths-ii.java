class Solution {
    public int f(int i, int j, int[][] dp, int[][] obstacleGrid) {
        if(i < 0 || j < 0 || obstacleGrid[i][j] == 1) return 0;

        if(i == 0 && j == 0) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        int up = f(i-1,j,dp, obstacleGrid);
        int left = f(i, j-1, dp, obstacleGrid);

        return dp[i][j] = up + left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n][m];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(n-1,m-1, dp, obstacleGrid);
    }
}