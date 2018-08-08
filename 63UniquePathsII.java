class Solution {
    public int uniquePathsWithObstacles(int[][] OG) {
        int m = OG.length;
        int n = OG[0].length;
        if ( OG[m-1][n-1] == 1 ) return 0;
        int[][] dp = new int[m][n];
        boolean[][] v = new boolean[m][n];
        v[m-1][n-1] = true;
        dp[m-1][n-1] = 1;
        return help(OG, dp, v, 0, 0);
    }
    public int help(int[][] OG, int[][] dp, boolean[][] v, int i, int j) {
        int m = OG.length;
        int n = OG[0].length;
        if ( i >= m || j >= n ) return 0;
        if ( v[i][j] ) return dp[i][j];
        v[i][j] = true;
        if ( OG[i][j] == 1 ) return 0;
        dp[i][j] = help(OG, dp, v, i+1, j) + help(OG, dp, v, i, j+1);
        return dp[i][j];
    }
}