/*
 * public class Solution {
public void setZeroes(int[][] matrix) {
    boolean fr = false,fc = false;
    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[i][j] == 0) {
                if(i == 0) fr = true;
                if(j == 0) fc = true;
                matrix[0][j] = 0;
                matrix[i][0] = 0;
            }
        }
    }
    for(int i = 1; i < matrix.length; i++) {
        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
    }
    if(fr) {
        for(int j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = 0;
        }
    }
    if(fc) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
    }
    
}
}
*/
class 73SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if ( m == 0 ) return;
        int n = matrix[0].length;
        if ( n == 0 ) return;
        help(matrix, 0, m, 0, n);
        for ( int i = 0; i < matrix.length; i++ ) for ( int j = 0; j < matrix[0].length; j++ ) if ( matrix[i][j] == -1000 ) matrix[i][j] = 0;
    }
    public void help(int[][] m, int r0, int r1, int c0, int c1) {
        if ( r0 >= r1 || c0 >= c1 ) return;
        for ( int i = r0; i < r1; i++ ) {
            for ( int j = c0; j < c1; j++ ) {
                if ( m[i][j] == 0 ) {
                    help(m, i+1, r1, 0, j+1);
                    help(m, i, r1, j+1, c1);
                    for ( int k = 0; k < m.length; k++ ) {
                        if ( m[k][j] != 0 ) m[k][j] = -1000;
                    }
                    for ( int k = 0; k < m[0].length; k++ ) {
                        if ( m[i][k] != 0 ) m[i][k] = -1000;
                    }
                    return;
                }
            }
        }
    }
}