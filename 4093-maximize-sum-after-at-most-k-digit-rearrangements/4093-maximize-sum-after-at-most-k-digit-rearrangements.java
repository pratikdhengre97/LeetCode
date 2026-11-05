class Solution {
    public long maximizeSum(int[] nums, int k) {

        int n = nums.length;
        
        long originalSum = 0;
        
        for(int num : nums) {
            originalSum += num;
        }

        long maxSum = Long.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++) {
            int original = nums[i];
            int rearrangedEle = findMaxRearrangement(nums[i]);

            int gain = rearrangedEle - original;
            pq.offer(gain);
        }
        while(k != 0) {
            originalSum += pq.poll();
            k--;
        }
        return originalSum;
    }
    public int findMaxRearrangement(int num) {
        ArrayList<Integer> list = new ArrayList<>();

        while(num > 0) {
            int n = num % 10; //3
            list.add(n);
            num = num/10;
        }
        Collections.sort(list, Collections.reverseOrder());
        // System.out.print(list);
        int newNum = 0;

        for(Integer it : list) {

            newNum = (newNum * 10) + it;
        }
        // System.out.print(newNum);
        return newNum;
    }
}