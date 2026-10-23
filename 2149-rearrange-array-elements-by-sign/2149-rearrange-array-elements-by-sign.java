class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length; //6
        int[] pos = new int[n/2]; // 3
        int[] neg = new int[n/2]; //3
        int[] ans = new int[n]; //6
        int j=0;
        int k=0;

        for(int i=0;i<n;i++) {
            if(nums[i] > 0) {
                pos[j++] = nums[i]; // 3 1 2 
            }
            else {
                neg[k++] = nums[i]; // -2, -5, -4
            }
        }
        int i = 0;
        int l = 0;
        j=0;
        k = 0;
        while(i<n/2) {
            ans[l++] = pos[j++]; // 3 //1 //2
            ans[l++] = neg[k++]; //-2 // -5 // -4
            i++;
        }
        return ans;
    }
}