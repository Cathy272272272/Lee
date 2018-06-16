class 62UniquePaths {
    public int uniquePaths(int m, int n) {
        if ( m == 0 || n == 0 ) return 0;
        int[][] matrix = new int[n][m];
        return help(m, n, 0, 0, matrix);
    }
    public int help(int m, int n, int r, int c, int[][] matrix) {
        if ( r == n -1 || c == m - 1 ) return 1;
        if ( matrix[r][c] == 0 ) matrix[r][c] = help(m, n, r+1, c, matrix) + help(m, n, r, c+1, matrix);
        return matrix[r][c];
    }
}