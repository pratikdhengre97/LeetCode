class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {

        int n = nums.length;
        int i = 0;
        int j = 0;

        long ans = 0;
        
        while(j<n){
          if(nums[j]<minK || nums[j]>maxK){
             i = j+1;
          }
          ans += j-i+1;
          j++;
          
        }

    return ans;
        
    }
}