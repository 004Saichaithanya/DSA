import java.util.*;

class Solution {

    long MOD = 1_000_000_007L;

    Long[][] dpMax;
    Long[][] dpMin;

    public int maxProductPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        dpMax = new Long[n][m];
        dpMin = new Long[n][m];

        long ans = recurFunc(0,0,grid,n,m)[0];

        if(ans < 0) return -1;

        return (int)(ans % MOD);
    }

    long[] recurFunc(int i,int j,int[][] grid,int n,int m){

        if(i==n-1 && j==m-1){
            return new long[]{grid[i][j], grid[i][j]};
        }

        if(dpMax[i][j] != null){
            return new long[]{dpMax[i][j], dpMin[i][j]};
        }

        long maxProd = Long.MIN_VALUE;
        long minProd = Long.MAX_VALUE;

        if(i+1 < n){

            long[] down = recurFunc(i+1,j,grid,n,m);

            long a = grid[i][j] * down[0];
            long b = grid[i][j] * down[1];

            maxProd = Math.max(maxProd, Math.max(a,b));
            minProd = Math.min(minProd, Math.min(a,b));
        }

        if(j+1 < m){

            long[] right = recurFunc(i,j+1,grid,n,m);

            long a = grid[i][j] * right[0];
            long b = grid[i][j] * right[1];

            maxProd = Math.max(maxProd, Math.max(a,b));
            minProd = Math.min(minProd, Math.min(a,b));
        }

        dpMax[i][j] = maxProd;
        dpMin[i][j] = minProd;

        return new long[]{maxProd, minProd};
    }
}