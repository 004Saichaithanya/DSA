class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int c=0;c<n;c++){
                int k=0;
                for( k = 0; k < n; k++){
                    if(grid[k][c] != grid[i][k]) break;
                }
                    if(k == n){
                    cnt++;
                    }

             }
        }

        return cnt;
    }
}