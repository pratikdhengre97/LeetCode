class Solution {
    public int robber(int i, int[] nums, int[] dp) {
        if(i < 0) return 0;
        if(i == 0) return nums[0];

        if(dp[i] != -1) return dp[i];

        int pick = nums[i] + robber(i-2, nums, dp);
        int notpick = robber(i-1, nums, dp);

        return dp[i] = Math.max(pick, notpick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return robber(n-1,nums, dp);
    }
}