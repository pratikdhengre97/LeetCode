class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();

        for(int i=0;i<n;i++) {
            if(mpp.containsKey(nums[i])) {
                mpp.put(nums[i], mpp.getOrDefault(nums[i], 0)+1);
            }
            else {
                mpp.put(nums[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> values : mpp.entrySet()) {
            if(values.getValue() > n/2) {
                return values.getKey();
            }
        }
        return -1;
    }
}