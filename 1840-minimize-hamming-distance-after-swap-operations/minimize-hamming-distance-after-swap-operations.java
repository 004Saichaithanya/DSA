class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        //graph --> Nodes are Indices in source and edges are swaps[i]
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int slen = source.length;
        int elen = allowedSwaps.length;
        int minHamDis = 0;

        for (int i = 0; i < slen; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < elen; i++) {
            int u = allowedSwaps[i][0];
            int v = allowedSwaps[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[slen];

        //each component 
        List<Integer> eachIndex;
        for (int i = 0; i < slen; i++) {
            if (!vis[i]) {
                eachIndex = new ArrayList<>();
                dfs(i, adj, vis, eachIndex);
                int hamDis = findMisMatch(source, target, eachIndex);
                minHamDis += hamDis;

            }
        }

        return minHamDis;

    }

    void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, List<Integer> eachIndex) {
        vis[node] = true;
        eachIndex.add(node);

        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, adj, vis, eachIndex);
            }
        }
    }

    int findMisMatch(int[] s, int[] tar, List<Integer> eachIndex) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = eachIndex.size();

        for (int i = 0; i < size; i++) {
            int idx = eachIndex.get(i);
            map.put(s[idx], map.getOrDefault(s[idx], 0) + 1);
        }

        int match = 0;

        for (int i = 0; i < size; i++) {
            int idx = eachIndex.get(i);
            int val = tar[idx];

            if (map.getOrDefault(val, 0) > 0) {
                match++;
                map.put(val, map.get(val) - 1);
                if (map.get(val) == 0)
                    map.remove(val);
            }

        }
        return size - match;
    }

}