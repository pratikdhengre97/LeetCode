class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int m = n/2;

        int[] arr1 = new int[m];
        int[] arr2 = new int[m];
        
        int k = 0;
        int l = 0;
        for(int i=0;i<n;i++) {
            if(nums[i] > 0) {
                arr1[k++] = nums[i];
            }
            else {
                arr2[l++] = nums[i];
            }
        }

        int[] ans = new int[n];
        int i = 0;
        int j = 0;
        k=0;
        while(i<m) {
            ans[k++] = arr1[i++];
            ans[k++] = arr2[j++];
        }

        return ans;
    }
}