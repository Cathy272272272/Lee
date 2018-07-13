/*
 * To get max length of increasing sequences:

Do DFS from every cell
Compare every 4 direction and skip cells that are out of boundary or smaller
Get matrix max from every cell's max
Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array
The key is to cache the distance because it's highly possible to revisit a cell
Hope it helps!

public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

public int longestIncreasingPath(int[][] matrix) {
    if(matrix.length == 0) return 0;
    int m = matrix.length, n = matrix[0].length;
    int[][] cache = new int[m][n];
    int max = 1;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            int len = dfs(matrix, i, j, m, n, cache);
            max = Math.max(max, len);
        }
    }   
    return max;
}

public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
    if(cache[i][j] != 0) return cache[i][j];
    int max = 1;
    for(int[] dir: dirs) {
        int x = i + dir[0], y = j + dir[1];
        if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
        int len = 1 + dfs(matrix, x, y, m, n, cache);
        max = Math.max(max, len);
    }
    cache[i][j] = max;
    return max;
}
*/
class 329LongestIncreasingPathinaMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if ( m == 0 ) return 0;
        int n = matrix[0].length;
        if ( n == 0 ) return 0;
        int dp[][] = new int[m][n];
        int max = 0;
        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                max = Math.max(max, help(matrix, dp, new boolean[m][n], i, j));
            }
        }
        return max;
    }
    public int help(int[][] matrix, int[][] dp, boolean[][] v, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        //if ( i < 0 || i >= n || j < 0 || j >= n ) return 0;
        if ( dp[i][j] != 0 ) return dp[i][j];
        if ( v[i][j] ) return 0;
        v[i][j] = true;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int max = 1;
        int r, c, count = 0;
        for ( int[] dir : dirs ) {
            r = i + dir[0];
            c = j + dir[1];
            if ( r < 0 || r >= m || c < 0 || c >= n ) continue;
            if ( matrix[r][c] > matrix[i][j] ) {
                max = Math.max(max, 1 + help(matrix, dp, v, r, c));
            }
            count++;
        }
        dp[i][j] = max;
        return dp[i][j];
    }
}