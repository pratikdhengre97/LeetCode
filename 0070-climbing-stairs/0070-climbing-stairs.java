class Solution {
    public int findStairs(int n, int[] dp) {
        if(n<=1) return 1;

        if(dp[n] != -1) return dp[n];

        dp[n] = findStairs(n-1, dp) + findStairs(n-2, dp);

        return dp[n];
    }
    public int climbStairs(int n) {
        
        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);

        int ans = findStairs(n, dp);

        return ans;
    }
}