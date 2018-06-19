class 48RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if ( n == 0 || n == 1 ) return;
        int l, a, b, c, d;
        for ( int i = 0; i < n / 2; i++ ) {
            l = n - i;
            for ( int j = i; j < l - 1; j++ ) {
                a = matrix[i][j];
                b = matrix[j][l - 1];
                c = matrix[l - 1][l - 1 - (j-i)];
                d = matrix[l - 1 - (j-i)][i];
                matrix[i][j] = d;
                matrix[j][l - 1] = a;
                matrix[l - 1][l - 1 - (j-i)] = b;
                matrix[l - 1 - (j-i)][i] = c;
            }
        }
    }
}