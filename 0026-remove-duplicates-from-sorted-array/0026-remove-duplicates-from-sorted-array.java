class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        int i=0;
        int j=i+1;

        while(i < n && j < n) {
            if(nums[i] == nums[j]) {
                j++;
            }
            else {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return i+1;
    }
}