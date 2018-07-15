class 131PalindromePartitioning {
    List<List<String>> list = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        help(s, 0, dp, new ArrayList<String>());
        return list;
    }
    public void help(String s, int start, int[][] dp, List<String> l) {
        int n = s.length();
        if ( start == n ) {
            list.add(new ArrayList<String>(l));
            return;
        }
        for ( int i = start + 1; i <= n; i++ ) {
            if ( palin(s, start, i, dp) > 0 ) {
                l.add(s.substring(start, i));
                help(s, i, dp, l);
                l.remove(l.size() - 1);
            }
        }
    }
    public int palin(String s, int i, int j, int[][] dp) {
        if ( dp[i][j-1] != 0 ) return dp[i][j-1];
        if ( i == j ) return 1;
        if ( i + 1 == j ) {
            dp[i][i] = 1;
            return 1;
        }
        if ( s.charAt(i) != s.charAt(j - 1) ) {
            dp[i][j-1] = -1;
            return -1;
        }
        dp[i][j-1] = palin(s, i+1, j-1, dp);
        return dp[i][j-1];
    }
}