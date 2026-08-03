class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int k = amount;
        int[] prev = new int[k+1];
        int[] curr = new int[k+1];

        for(int t=0;t<=k;t++) {
            if(t%coins[0] == 0) {
                prev[t] = t/coins[0];
            }
            else {
                prev[t] = Integer.MAX_VALUE;
            }
        }

        for(int ind=1;ind<n;ind++) {
            for(int t=0;t<=k;t++) {
                int notTake = prev[t];

                int take = Integer.MAX_VALUE;
                if(coins[ind] <= t) {
                    int result = curr[t-coins[ind]];
                if(result != Integer.MAX_VALUE) {
                    take = 1 + result;
                }
            }
                curr[t] = Math.min(take, notTake);
            }
            prev = curr;
        }
        return prev[k] == Integer.MAX_VALUE ? -1 : prev[k];
    }
}