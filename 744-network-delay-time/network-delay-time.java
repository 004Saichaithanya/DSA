class Pair{
    int dist,node;
    public Pair(int dist,int node){
        this.dist=dist;
        this.node=node;
    }
}


class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
         ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int d = times[i][2];
            adjList.get(u).add(new Pair(d,v));
        }

        PriorityQueue<Pair> pq=
        new PriorityQueue<>((a,b)->a.dist-b.dist);

        int[] dist=new int[n+1];
        int INF=(int)1e9;

        Arrays.fill(dist,INF);
        dist[k]=0;
        pq.add(new Pair(0,k));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int w = p.dist;
            int node=p.node;

            for(Pair padj : adjList.get(node)){
                int adj = padj.node;
                int dt = padj.dist;
                if(w + dt < dist[adj]){
                    dist[adj]=w+dt;
                    pq.add(new Pair(dist[adj],adj));
                }
            }
        }

        int minTime=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==INF)
            return -1;
        if(i != k)
        minTime = Math.max(minTime,dist[i]);
        }

        return minTime;
    }
}