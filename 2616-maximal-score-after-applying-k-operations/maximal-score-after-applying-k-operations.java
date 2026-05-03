class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : nums)
            pq.add(x);

        long ans = 0;
        int i = 0;

        while (i < k && !pq.isEmpty()) {
            int ele = pq.poll();
            //  System.out.println(ele);
            ans += ele;
            int val = (int) Math.ceil((double) ele / 3);
            // System.out.println(Math.ceil((double)ele/3));
            pq.add(val);
            i++;
        }

        return ans;
    }
}