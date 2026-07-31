class Solution {
    public boolean subsetSum(int ind, int[] nums, int target, int[][] dp) {
        if(target == 0) return true;

        if(ind == 0) return nums[ind] == target;

        if(dp[ind][target] != -1) return dp[ind][target] == 1;

        boolean notTaken = subsetSum(ind-1, nums, target, dp);

        boolean taken = false;
        if(nums[ind] <= target) {
            taken = subsetSum(ind-1, nums, target-nums[ind], dp);
        }

        dp[ind][target] = (taken || notTaken) ? 1 : 0;

        return notTaken || taken;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        if(total%2 != 0) return false;

        total = total/2;

        int[][] dp = new int[n][total+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }


        return subsetSum(n-1, nums, total, dp);
    }
}