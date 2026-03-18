class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] preSum=new int[n][m];
        int cnt=0;
        preSum[0][0] = grid[0][0];
        if(preSum[0][0] <= k )cnt++;


        //row
        for(int j=1;j<m;j++){
            preSum[0][j] = preSum[0][j-1]+ grid[0][j]; 
            if(preSum[0][j] <= k)
            cnt++;
        }

    // for(int arr[] : preSum){
    //         for(int x: arr)
    //     System.out.print(x+" ");
    //     System.out.println();
    //     }

    //       System.out.println("cnt:"+cnt);

        //column

        for(int i=1;i<n;i++){
            preSum[i][0] = preSum[i-1][0]+grid[i][0];
            if(preSum[i][0]<=k)
            cnt++;
        }

        // for(int arr[] : preSum){
        //     for(int x: arr)
        // System.out.print(x+" ");
        // System.out.println();
        // }

        // System.out.println("cnt:"+cnt);

        //diaganal
        int[][] dia=new int[n][m];
        //dia[0][0]=grid[0][0];

        for(int i=0;i<n;i++){
            dia[i][0]=grid[i][0];
            for(int j=1;j<m;j++){
                dia[i][j] = dia[i][j-1]+ grid[i][j]; 

            }
        }

        // for(int arr[] : dia){
        //     for(int x: arr)
        // System.out.print(x+" ");
        // System.out.println();
        // }
        // System.out.println("hello");


        for(int j=1;j<m;j++){
            for(int i=1;i<n;i++){
                dia[i][j] = dia[i-1][j] + dia[i][j];
                if(dia[i][j] <= k)
                cnt++; 
            }
        }



        // for(int arr[] : dia){
        //     for(int x: arr)
        // System.out.print(x+" ");
        // System.out.println();
        // }

        // System.out.println("cnt:"+cnt);

        return cnt;
    }
}