class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int k = amount;

        int[][] dp = new int[n][k+1];

        for(int t=0;t<=k;t++) {
            if(t%coins[0] == 0) {
                dp[0][t] = t/coins[0];
            }
            else {
                dp[0][t] = Integer.MAX_VALUE;
            }
        }

        for(int ind=1;ind<n;ind++) {
            for(int t=0;t<=k;t++) {
                int notTake = dp[ind-1][t];

                int take = Integer.MAX_VALUE;
                if(coins[ind] <= t) {
                    int result = dp[ind][t-coins[ind]];

                    if(result != Integer.MAX_VALUE) {
                        take = 1 + result;
                    }
                }

                dp[ind][t] = Math.min(take, notTake);
            }     
        }
        return dp[n-1][k] == Integer.MAX_VALUE ? -1 : dp[n-1][k];
    }
}