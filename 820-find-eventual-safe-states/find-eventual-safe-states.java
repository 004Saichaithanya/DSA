class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        ArrayList<ArrayList<Integer>> graphRev = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graphRev.add(new ArrayList<>());

        int[] inDeg = new int[n];

        for (int i = 0; i < n; i++) {
            for (int it : graph[i]) {
                graphRev.get(it).add(i);
                inDeg[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int adjacent : graphRev.get(node)) {
                inDeg[adjacent]--;
                if (inDeg[adjacent] == 0)
                    q.add(adjacent);
            }
        }

        Collections.sort(ans);

        return ans;
    }
}