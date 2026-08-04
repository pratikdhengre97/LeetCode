class Solution {
    public int f(int ind, int target, int[] coins, int[][] dp) {
        if(ind == 0) {
            return target%coins[0] == 0 ? 1 : 0;
        }
        if(dp[ind][target] != -1) {
            return dp[ind][target];
        }
        int notPick = f(ind-1, target, coins, dp);

        int pick = 0;
        if(coins[ind] <= target) {
            pick = f(ind, target-coins[ind], coins, dp);
        }

        return dp[ind][target] = pick + notPick;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int t = amount;

        int[][] dp = new int[n][t+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(n-1, t, coins, dp);
    }
}