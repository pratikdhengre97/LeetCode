class Solution {
    public int robber(int ind, int[] nums, int[] dp) {
        if(ind < 0) return 0;

        if(ind == 0) return nums[0];

        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + robber(ind-2,nums,dp);

        int notpick = robber(ind-1, nums, dp);

        return dp[ind] = Math.max(pick, notpick);

    }
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return robber(n-1, nums, dp);
    }
}