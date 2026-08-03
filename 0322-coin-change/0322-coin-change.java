class Solution {
    public int f(int ind, int[] coins, int t, int [][] dp) {
        if(ind == 0) {
            if(t%coins[ind] == 0) {
                return t/coins[ind];
            }
            return Integer.MAX_VALUE;
        }

        if(dp[ind][t] != -1) return dp[ind][t];

        int notTake = f(ind-1, coins, t, dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind] <= t) {
            int result = f(ind, coins , t-coins[ind], dp);

            if(result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }
        return dp[ind][t] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int t = amount;

        int[][] dp = new int[n][t+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = f(n-1, coins, amount, dp);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}