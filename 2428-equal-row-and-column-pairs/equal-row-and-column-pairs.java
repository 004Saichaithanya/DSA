class Solution {
    public int equalPairs(int[][] grid) {
        //"3,2,1"(row) --> 1(freq)
        HashMap<String, Integer> map = new HashMap<>();
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j != n - 1)
                    str.append(grid[i][j] + ",");
                else
                    str.append(grid[i][j]);
            }
            map.put(str.toString(), map.getOrDefault(str.toString(), 0) + 1);

        }
        // System.out.println(map);

        int cnt = 0;

        for (int j = 0; j < n; j++) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i != n - 1)
                    str.append(grid[i][j] + ",");
                else
                    str.append(grid[i][j]);

            }
            //     System.out.println(str.toString());
            //    // if(map.containsKey(str.toString()))
            cnt += map.getOrDefault(str.toString(), 0);
        }

        return cnt;
    }
}