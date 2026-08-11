class Solution {
    public int f(int ind, int[] coins, int target, int[][] dp) {

        if(ind == 0) {
            if(target%coins[ind] == 0) {
                return target/coins[0];
            }
            return Integer.MAX_VALUE;
        }

        if(dp[ind][target] != -1) return dp[ind][target];

        int notTake = f(ind-1,coins,target, dp);

        int take = Integer.MAX_VALUE;

        if(coins[ind] <= target) {
            int result = f(ind, coins, target-coins[ind], dp);

            if(result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }

        return dp[ind][target] =  Math.min(take, notTake);

    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int t = amount;
        int[][] dp = new int[n][t+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = f(n-1,coins,amount, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}