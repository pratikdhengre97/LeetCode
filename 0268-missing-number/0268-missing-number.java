class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumOfNaturalNumbers = n*(n+1)/2;

        int sumOfArray = 0;

        for(int i=0;i<n;i++) {
            sumOfArray += nums[i];
        }

        return sumOfNaturalNumbers - sumOfArray;
    }
}