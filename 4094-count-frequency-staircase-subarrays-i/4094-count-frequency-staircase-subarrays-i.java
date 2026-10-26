class Solution {
    public int countStaircase(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int i=0;i<n;i++) {
            Map<Integer, Integer> mpp = new LinkedHashMap<>();

            for(int j=i;j<n;j++) {
                mpp.put(nums[j], mpp.getOrDefault(nums[j], 0)+1);

                int expected = 1;
                boolean valid = true;

                for(int freq : mpp.values()) {
                    if(freq != expected) {
                        valid = false;
                        break;
                    }
                    expected++;
                }
                if(valid) {
                    ans++;
                }
            }
        }
        return ans;
    }
}