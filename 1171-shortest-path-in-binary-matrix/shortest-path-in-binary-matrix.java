class Pair{
    int dist;
    int[] loc;
    public Pair(int dist,int[] loc){
        this.dist=dist;
        this.loc = loc;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;
        // if start and end are blocked , then no path !
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)
        return -1;

        if(n == 1 && m == 1) return 1;

        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[n][m];

        q.add(new Pair(1,new int[]{0,0}));
        int INF=(int)1e9;
        for(int[] arr : vis)
        Arrays.fill(arr,INF);
        vis[0][0]=1;

        //8 directional list
        int[] drow = new int[]{-1,-1,0,+1,+1,+1,0,-1};
        int[] dcol=new int[]{0,+1,+1,+1,0,-1,-1,-1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int w = p.dist;
            int r = p.loc[0];
            int c = p.loc[1];

            for(int i=0;i<8;i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];

            if(nrow >=0 && ncol >=0 && nrow < n && ncol < m && 
            grid[nrow][ncol] == 0 && w + 1 < vis[nrow][ncol]){
                vis[nrow][ncol] = w + 1;
                if(nrow == n-1 && ncol == n-1)
                return  vis[nrow][ncol];
                q.add(new Pair(vis[nrow][ncol],new int[]{nrow,ncol}));

            }
            }

        }
            
        return -1;
    }
}