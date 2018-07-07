class 764LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int order = 0, count = 0, ii = 0, jj = 0;
        int[][] m = new int[N][N];
        for ( int[] i : m ) Arrays.fill(i, 1);
        int[][] moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for ( int[] i : mines ) m[i[0]][i[1]] = 0;
        for ( int i = 0; i < N; i++ ) {
            for ( int j = 0; j < N; j++ ) {
                if ( m[i][j] == 0 ) continue;
                count = 0;
                Search:
                while ( true ) {
                    for ( int[] k : moves ) {
                        ii = i + (count / 4 + 1) * k[0];
                        jj = j + (count / 4 + 1) * k[1];
                        if ( ii < N && jj < N && ii >= 0 && jj >= 0 ) {
                            if ( m[ii][jj] == 1 ) count++;
                            else break Search;
                        }
                        else break Search;
                    }
                }
                if ( order < count / 4 + 1 ) order = count / 4 + 1;
            }
        }
        return order;
     }
}