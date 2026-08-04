class Solution {
    public int f(int ind, int sum, int[] nums, int target) {
        if(ind == nums.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        int add = f(ind+1,sum+nums[ind], nums, target);

        int subtract = f(ind+1, sum-nums[ind], nums, target);

        return add + subtract;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return f(0, 0, nums, target);
    }
}