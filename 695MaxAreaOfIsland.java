class 695MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int temp;
        for ( int i = 0; i < grid.length; i++ )
            for ( int j = 0; j < grid[0].length; j++ ){
                temp = go(i,j,grid);
                if ( temp > max )
                    max = temp;
                }
        return max;
    }
    public int go (int i, int j, int[][] grid) {
        if ( grid[i][j] == 0 ) return 0;
        System.out.println(i + " " + j);
        grid[i][j] = 0;
        int count = 1;
        if ( i + 1 < grid.length) if ( grid[i + 1][j] == 1 ) count += go(i+1,j,grid); 
        if ( i - 1 >= 0 ) if ( grid[i - 1][j] == 1 ) count += go(i-1,j,grid);
        if ( j + 1 < grid[0].length ) if ( grid[i][j + 1] == 1 ) count += go(i,j+1,grid);
        if ( j - 1 >= 0 ) if ( grid[i][j - 1] == 1 ) count += go(i,j-1,grid);
        return count;
    }
}