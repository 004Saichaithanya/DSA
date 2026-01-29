class Pair {
    int dist;
    int node;


    public Pair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}


class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();


        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());


        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int d = edges[i][2];
            adjList.get(u).add(new Pair(d, v));
            adjList.get(v).add(new Pair(d, u));
        }

        int[] cnt=new int[n];
        int[] dist=new int[n];
        int INF=(int)1e9;

        for(int i=0;i<n;i++){

        dijistra(i,adjList,dist,distanceThreshold);

        for(int j=0;j<n;j++){
            if(j != i && dist[j] <= distanceThreshold){
                cnt[i]++;
            }
        }
        }

        // for(int i=0;i<n;i++){
        //     System.out.print(cnt[i]+" ");
        // }
            int min=cnt[0],idx=0;
            for (int i = 1; i < cnt.length; i++) {
        if (cnt[i] < min) {
            min = cnt[i];
            idx = i;
        } else if (cnt[i] == min) {
            // if equal min dist , take greater element node 
            idx = i;
        }
    }

    return idx;
    }
    void dijistra(int start,ArrayList<ArrayList<Pair>> adjList,int[] dist,int thres){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Pair(0,start));
        int INF=(int)1e9;
        Arrays.fill(dist,INF);
        dist[start]=0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int w=p.dist;
            int node=p.node;

            if(w > dist[node]) continue;

            for(Pair padj : adjList.get(node)){
                int adj=padj.node;
                int dt=padj.dist;

                if(w + dt < dist[adj]){
                    dist[adj]=w+dt;
                    pq.add(new Pair(dist[adj],adj));
                 //   cnt[start]++;
                }
            }
        }
    }

}