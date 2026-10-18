class Solution {
    public int insert(int[] ans, int[] nums, int firstIndex, int lastIndex, int l) {
        int n = nums.length;
        for(int i=firstIndex;i<=lastIndex;i++) {
            ans[l++] = nums[i];
        }
        return l;
    }
    public void rotate(int[] nums, int k) {
        
        
        int n = nums.length;
        k = k % n;
        int[] ans = new int[n];
        int l = 0;

        l = insert(ans, nums, n-k, n-1, l);
        l = insert(ans, nums, 0, n-k-1, l);

        for(int i=0;i<ans.length;i++) {
            nums[i] = ans[i];
        }
    }
}