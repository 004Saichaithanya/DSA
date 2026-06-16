class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        for (int x : stones)
            pq.offer(x);

        int w1 = 0;

        while (!pq.isEmpty()) {
            w1 = pq.poll();
            if (pq.isEmpty())
                break;
            int w2 = pq.poll();
            if (w1 != w2) {
                int diff = Math.abs(w2 - w1);
                //System.out.println(diff);
                pq.offer(diff);
            }else{
                w1=0;
            }

        }

        return w1;
    }
}