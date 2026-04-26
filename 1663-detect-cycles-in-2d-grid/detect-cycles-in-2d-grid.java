class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        char parent = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] != 1) {
                    if (dfs(i, j, grid, vis, i, j, n, m) == true)
                        return true;
                }
            }
        }

        return false;

    }

    boolean dfs(int i, int j, char[][] grid, int[][] vis, int pi, int pj, int n, int m) {

        vis[i][j] = 1;
        boolean b1 = false, b2 = false, b3 = false, b4 = false;
        //up
        if (i - 1 >= 0 && grid[i - 1][j] == grid[i][j]) {
            if (vis[i - 1][j] == 1 && !(i - 1 == pi && j == pj))
                return true;
            if (vis[i - 1][j] == 0)
                b1 = dfs(i - 1, j, grid, vis, i, j, n, m);
        }
        //down
        if (i + 1 < n && grid[i + 1][j] == grid[i][j]) {
            if (vis[i + 1][j] == 1 && !(i + 1 == pi && j == pj))
                return true;
            if (vis[i + 1][j] == 0)
                b2 = dfs(i + 1, j, grid, vis, i, j, n, m);
        }
        //right
        if (j + 1 < m && grid[i][j + 1] == grid[i][j]) {
            if (vis[i][j + 1] == 1 && !(i == pi && j + 1 == pj))
                return true;
            if (vis[i][j + 1] == 0)
                b3 = dfs(i, j + 1, grid, vis, i, j, n, m);
        }
        //left
        if (j - 1 >= 0 && grid[i][j - 1] == grid[i][j]) {
            if (vis[i][j - 1] == 1 && !(i == pi && j - 1 == pj))
                return true;
            if (vis[i][j - 1] == 0)
                b4 = dfs(i, j - 1, grid, vis, i, j, n, m);
        }

        return b1 || b2 || b3 || b4;

    }
}