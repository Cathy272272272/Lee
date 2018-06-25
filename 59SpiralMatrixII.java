class 59SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int count = 1, r, c, n2 = (int)Math.pow(n, 2);
        int[][] m = new int[n][n];
        int help = n - 1;
        Search:
        for ( int i = n; i > n / 2; i-- ) {
            //go right
            r = n - i;
            c = n - i;
            for ( int j = 0; j < help; j++ ) {
                m[r][c+j] = count++;
                if ( count > n2 ) break Search;
            }
            //go down
            r = n - i;
            c = i - 1;
            for ( int j = 0; j < help; j++ ) {
                m[r+j][c] = count++;
                if ( count > n2 ) break Search;
            }
            //go left
            r = i - 1;
            c = i - 1;
            for ( int j = 0; j < help; j++ ) {
                m[r][c-j] = count++;
                if ( count > n2 ) break Search;
            }
            //go up
            r = i - 1;
            c = n - i;
            for ( int j = 0; j < help; j++ ) {
                m[r-j][c] = count++;
                if ( count > n2 ) break Search;
            }
            help -= 2;
        }
        if ( n % 2 == 1 ) m[n/2][n/2] = count;
        return m;
    }
}