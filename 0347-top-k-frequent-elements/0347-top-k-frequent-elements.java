class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }

        int[] ans = new int[k];

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        pq.addAll(freq.entrySet());

        for(int i=0;i<k;i++) {
            ans[i] = pq.poll().getKey();
        }

        return ans;
    }
}