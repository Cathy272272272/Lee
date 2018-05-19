class 463IslandPerimeter{
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        if ( grid.length >= 0 && grid.length <= 100 && grid[0].length >= 0 && grid[0].length <= 100 )
            for ( int i = 0; i < grid.length; i++ )
                for ( int j = 0; j <grid[0].length; j++ ){
                    if ( grid[i][j] == 1 ){
                        sum += 4;
                        if ( i - 1 >= 0 )
                            if ( grid[i - 1][j] == 1 )
                            sum -= 2;
                        if ( j - 1 >= 0 )
                            if ( grid[i][j - 1] == 1 )
                            sum -= 2;
                    }
                }
        return sum;
            
    }
}