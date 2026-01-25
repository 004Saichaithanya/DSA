class Tuple{
    int diff,row,col;
    public Tuple(int diff,int row,int col){
        this.diff=diff;
        this.row=row;
         this.col=col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n= heights.length;
        int m=heights[0].length;
PriorityQueue<Tuple> pq =
    new PriorityQueue<>((a, b) -> a.diff - b.diff);


        int[][] dist=new int[n][m];
        int INF=(int)1e9;
        for(int[] arr:dist)
        Arrays.fill(arr,INF);

        pq.add(new Tuple(0,0,0));
        dist[0][0]=0;

        int[] drow = new int[]{-1,0,+1,0};
        int[] dcol = new int[]{0,+1,0,-1};

        int minEff=INF;

        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int w = t.diff;
            int r = t.row;
            int c = t.col;

            if( r == n-1 && c == m-1 )
            return w;

        for(int i=0;i<4;i++){
        int nrow = r + drow[i];
        int ncol = c+dcol[i];
        if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m){
            int newWt =  Math.max (w, Math.abs(heights[r][c] - heights[nrow][ncol]));
           if(newWt < dist[nrow][ncol]) {
            dist[nrow][ncol]=newWt;
            pq.add(new Tuple(newWt,nrow,ncol));
           }

            
        }
        }



        }

    return dist[n-1][m-1];  // unreachable 
    }
}