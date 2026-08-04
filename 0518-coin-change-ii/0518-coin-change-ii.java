class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int target = amount;

        int[][] dp = new int[n][target+1];

        for(int i=0;i<=target;i++) {
            if(i%coins[0] == 0) {
                dp[0][i] = 1;
            }
        }

        for(int ind=1;ind<n;ind++) {
            for(int t=0;t<=target;t++) {
                int notPick = dp[ind-1][t];

                int pick = 0;
                if(coins[ind]<=t) {
                    pick = dp[ind][t-coins[ind]];
                }

                dp[ind][t] = pick + notPick;
            }
        }
        return dp[n-1][target];
    }
}