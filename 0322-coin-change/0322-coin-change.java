class Solution {
    public int f(int index, int[] coins, int target, int[][] dp) {
        if(index == 0) {
            if(target%coins[index] == 0) {
                return target/coins[index];
            }
            return Integer.MAX_VALUE;
        }

        if(dp[index][target] != -1) return dp[index][target];

        int notPick = f(index-1, coins, target, dp);

        int pick = Integer.MAX_VALUE;

        if(coins[index] <= target) {
            int result = f(index, coins, target-coins[index], dp);

            if(result != Integer.MAX_VALUE) {
                pick = 1 + result;
            }
        }

        return dp[index][target] = Math.min(pick, notPick);
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