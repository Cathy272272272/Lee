class 200NumberofIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if ( m == 0 ) return 0;
        int n = grid[0].length;
        if ( n == 0 ) return 0;
        int [] uf = new int[m*n];
        for ( int i = 0; i < m*n; i++ ) uf[i] = i;
        int count = 0;
        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                if ( grid[i][j] == '1' && uf[i*n+j] >= 0 ) {
                    count++;
                    color(grid, uf, i, j);
                }
            }
        }
        return count;
    }
    public void color(char[][] grid, int[] uf, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if ( i < 0 || j < 0 || i >= m || j >= n ) return;
        if ( uf[i*n+j] == -1 || grid[i][j] == '0' ) return;
        uf[i*n+j] = -1;
        color(grid, uf, i+1, j);
        color(grid, uf, i-1, j);
        color(grid, uf, i, j+1);
        color(grid, uf, i, j-1);
    }
}