class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();

        for(int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> values : mpp.entrySet()) {
            if(values.getValue() > n/2) {
                return values.getKey();
            }
        }
        return -1;
    }
}