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
        int[] dp = new int[subset+1];

        dp[0] = 1;

        for(int num : nums) {
            for(int j=subset;j>=num;j--) {
                dp[j] += dp[j-num];
            }
        }
        return dp[subset];
    }
}