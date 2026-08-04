class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int target = amount;

        int[] prev = new int[target+1];

        for(int i=0;i<=target;i++) {
            if(i%coins[0] == 0) {
                prev[i] = 1;
            }
        }

        for(int ind=1;ind<n;ind++) {
            int[] curr = new int[target+1];
            for(int t=0;t<=target;t++) {
                int notPick = prev[t];

                int pick = 0;
                if(coins[ind]<=t) {
                    pick = curr[t-coins[ind]];
                }
                curr[t] = pick + notPick;
            }
            prev = curr;
        }
        return prev[target];
    }
}