class 498DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if ( m == 0 ) return new int[0];
        int n = matrix[0].length;
        if ( n == 0 ) return new int[0];
        int[] res = new int[m*n];
        int r = 0, c = 0, count = 0, diag = 0, help = 0, max = 0;
        for ( diag = 0; diag < m + n - 1; diag++ ) {
            if ( diag < (int) Math.min(n - 1, m - 1 )) 
                help = diag;
            else if ( diag <= (int) Math.max(n - 1, m - 1 ) && diag >= (int) Math.min(n - 1, m - 1 )) 
                help = Math.min(m,n) - 1;
            else 
                help = m + n - 2 - diag;
            if ( diag % 2 == 0 ) {
                    for ( int i = 0; i <= help; i++ ) 
                        res[count++] = matrix[r--][c++];
                    if ( diag < n - 1 ) 
                        r++;
                    else {
                        r += 2;
                        c--;
                    }
                }
                else {
                    for ( int i = 0; i <= help; i++ ) 
                            res[count++] = matrix[r++][c--];
                    if ( diag < m - 1 ) 
                        c++;
                    else {
                        c += 2;
                        r--;
                    }
                }
        }
        return res;
    }
}