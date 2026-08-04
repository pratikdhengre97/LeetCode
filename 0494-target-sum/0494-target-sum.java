class Solution {
    public int f(int ind,int[] nums, int target, int[][] dp) {

        if(ind == 0) {
            if(target == 0 && nums[0] == target) return 2;

            if(target == 0 || nums[0] == target) return 1;

            return 0;
        }

        if(dp[ind][target] != -1) return dp[ind][target];


        int notPick = f(ind-1,nums, target, dp);

        int pick = 0;

        if(nums[ind] <= target) {
            pick = f(ind-1,nums,target-nums[ind],dp);
        }
        return dp[ind][target] = pick + notPick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int t = target;

        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }

        if((totalSum-target) < 0 || (totalSum-target)%2 != 0) return 0;

        int subset = (totalSum-target)/2;

        int[][] dp = new int[n][subset+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(n-1,nums,subset,dp);
    }
}