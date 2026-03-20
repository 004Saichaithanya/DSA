class Pair{
    int row,col,time;
    public Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int freshCnt=0;
        int maxTime=0;
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else if(grid[i][j]==0)
                    vis[i][j]=0;
                else{
                    vis[i][j]=1;
                    freshCnt++;
                    }
            }
        }
        if(freshCnt ==0) return 0;

        int maxtime=0,cnt=0;

        int[] drow=new int[]{-1,0,1,0};
        int[] dcol=new int[]{0,1,0,-1};

        while(!q.isEmpty()){
            Pair p=q.poll();
            int row=p.row;
            int col=p.col;
            int time=p.time;

            maxtime=Math.max(maxtime,time);
            
            for(int i=0;i<4;i++){
                int r = row + drow[i];
                int c= col+dcol[i];

                if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1 && vis[r][c] != 2){
                    q.add(new Pair(r,c,time+1));
                    vis[r][c]=2;
                    cnt++;
                }
            }
            


        }
        return (freshCnt == cnt)?maxtime:-1;
    }
}