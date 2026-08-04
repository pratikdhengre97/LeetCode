class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int k = target;

        int totalSum = 0;

        for(int num : nums) {
            totalSum += num;
        }

        if((totalSum-target) < 0 || (totalSum-target)%2 != 0) return 0;

        int subset = (totalSum-target)/2;

        int[][] dp = new int[n+1][subset+1];

        for(int i=0;i<=n;i++) {
            dp[i][0] = 1;
        }

        for(int ind=1;ind<=n;ind++) {
            for(int t=0;t<=subset;t++) {
                dp[ind][t] = dp[ind-1][t];

                if(nums[ind-1] <= t) {
                    dp[ind][t] += dp[ind-1][t-nums[ind-1]];
                }
            }
        }
        return dp[n][subset];
    }
}