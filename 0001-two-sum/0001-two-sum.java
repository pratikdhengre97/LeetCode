class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer,Integer> mpp = new HashMap<>();

        for(int i=0;i<n;i++) {
            if(mpp.containsKey(target-nums[i])) {
                return new int[]{i,mpp.get(target-nums[i])};
            }
            mpp.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}