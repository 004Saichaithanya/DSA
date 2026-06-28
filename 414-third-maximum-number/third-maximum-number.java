class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            if (set.contains(x))
                continue;
            pq.offer(x);
            if(pq.size() > 3)  
                pq.poll();
            set.add(x);
        }

        return (pq.size() == 3) ? pq.peek() : getMax(nums);
    }

    int getMax(int[] nums) {
        int maxEle = Integer.MIN_VALUE;
        //  System.out.println("h");
        for (int x : nums)
            maxEle = Math.max(maxEle, x);

        return maxEle;
    }
}