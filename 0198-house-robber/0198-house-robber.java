class Solution {
    public int f(int index, int[] nums, int[] dp) {
        if(index == 0) {
            return nums[index];
        }
        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];

        int notPick = f(index-1, nums,dp);

        int pick = nums[index] + f(index-2, nums,dp);

        return dp[index] = Math.max(pick, notPick);
    }
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return f(n-1, nums, dp);
    }
}