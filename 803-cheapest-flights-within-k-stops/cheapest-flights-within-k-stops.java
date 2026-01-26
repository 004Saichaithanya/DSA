class Tuple{
    int stops,node,dist;
    public Tuple(int stops,int node,int dist){
        this.stops=stops;
        this.node=node;
        this.dist=dist;
    }
}
class Pair{
    int node,dist;
    public Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // 1. create graph
        ArrayList<ArrayList<Pair>> adjList=new ArrayList<>();

        for(int i=0;i<n;i++)
        adjList.add(new ArrayList<>());

        for(int i=0;i<flights.length;i++){
            int u = flights[i][0];
            int v=flights[i][1];
            int d=flights[i][2];
            adjList.get(u).add(new Pair(v,d));
        }

        Queue<Tuple> q=new LinkedList<>();
        int[] dist=new int[n];
        int INF=(int)1e9;

        Arrays.fill(dist,INF);

        // stops,node,dist
        q.add(new Tuple(0,src,0));
        dist[src]=0;

        while(!q.isEmpty()){
            Tuple t =q.poll();
            int w = t.dist;
            int stps = t.stops;
            int node = t.node;

            for(Pair p : adjList.get(node)){
                int adj = p.node;
                int dt = p.dist;
                if(stps+1 <= k+1 && w + dt < dist[adj]){
                    dist[adj]=w+dt;
                    q.add(new Tuple(stps+1,adj,dist[adj]));
                }
            }
        }
        return (dist[dst] == INF)?-1:dist[dst];
    }
}