class 661ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int r = M.length;
        int c = M[0].length;
        if ( r < 1 || r > 150 || c < 1 || c > 150 ) return null;
        int[][] res = new int[r][c];
        for ( int i = 0; i < c; i++ ) {
            for ( int j = 0; j < r; j++ ) {
                int count = 0;
                int size = 0;
                for ( int k = -1; k < 2; k++ ) {
                    for ( int l = -1; l < 2; l++ ) {
                        if ( i + k >= 0 && i + k < c && j + l >= 0 && j + l < r ) {
                            count += M[j+l][i+k];
                            size++;
                        }
                    }
                }
                res[j][i] = count / size;
            }
        }
        return res;
    }
}