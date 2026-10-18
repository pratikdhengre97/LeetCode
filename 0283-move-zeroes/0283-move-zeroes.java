class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int j = 0;
        int cnt0 = 0;
        for(int i=0;i<n;i++) {
            if(nums[i] == 0) {
                cnt0++;
            }
            else {
                ans[j++] = nums[i];
            }
        }

        for(int i=0;i<cnt0;i++) {
            ans[j++] = 0;
        }

        for(int i=0;i<ans.length;i++) {
            nums[i] = ans[i];
        }
    }
}