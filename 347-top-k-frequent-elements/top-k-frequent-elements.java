class Pair {
    int key, cnt;

    public Pair(int key, int cnt) {
        this.key = key;
        this.cnt = cnt;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : nums)
            map.put(x, map.getOrDefault(x, 0) + 1);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (p, q) -> p.cnt - q.cnt);

        for (int key : map.keySet()) {
            Pair p = new Pair(key, map.get(key));
            pq.add(p);
            if (pq.size() > k)
                pq.poll();
        }
        int[] ans = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i] = pq.poll().key;
            i++;
        }
        return ans;
    }
}