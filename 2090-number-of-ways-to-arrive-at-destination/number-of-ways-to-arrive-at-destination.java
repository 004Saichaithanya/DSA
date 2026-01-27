class Pair {
    long dist;
    int node;


    public Pair(long dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
         ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();


        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());


        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int d = roads[i][2];
            adjList.get(u).add(new Pair(d, v));
            adjList.get(v).add(new Pair(d, u));
        }

         PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

         long[] dist=new long[n];
         int[] ways=new int[n];
         long INF=(long)1e18;
         int mod = (int)(1e9+7);

         Arrays.fill(dist,INF);
         dist[0]=0;
         ways[0]=1;

         pq.add(new Pair(0,0));

         while(!pq.isEmpty()){
            Pair p=pq.poll();
            long w = p.dist;
            int node = p.node;

            if (w > dist[node]) continue;

            for(Pair padj : adjList.get(node)){
                int adj = padj.node;
                long dt = padj.dist;

                if(w + dt < dist[adj]){
                    dist[adj]=w+dt;
                    pq.add(new Pair(dist[adj],adj));
                    ways[adj]=ways[node];
                }else if(w + dt == dist[adj]){
                    ways[adj]=(ways[adj]+ways[node])%mod;
                }
            }
         }


         return ways[n-1]%mod;

    }
}