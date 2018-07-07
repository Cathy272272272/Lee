class 240Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if ( m == 0 ) return false;
        int n = matrix[0].length;
        if ( n == 0 ) return false;
        boolean[] v = new boolean[m];
        return col(matrix, v, 0, m-1, target);
    }
    public boolean col(int[][] matrix, boolean[] v, int lm, int hm, int target) {
        if ( lm < 0 || hm < 0 || lm >= matrix.length || hm >= matrix.length ) return false;
        int mm = (lm + hm) / 2;
        if ( v[mm] ) return false;
        v[mm] = true;
        if ( row(matrix[mm], target) ) return true;
        if ( matrix[mm][matrix[0].length-1] < target ) {
            lm = mm + 1;
            return col(matrix, v, lm, hm, target);
        }
        else if ( matrix[mm][0] > target ) {
            hm = mm - 1;
            return col(matrix, v, lm, hm, target);
        }
        else {
            return col(matrix, v, mm+1, hm, target) || col(matrix, v, lm, mm-1, target);            
        } 
    }
    public boolean row(int[] row,int target) {
        int ln = 0, hn = row.length - 1, mn;
        while ( row[ln] < row[hn] ) {
            mn = ( ln + hn ) / 2;
            if ( row[mn] < target ) {
                ln = mn + 1;
            }
            else hn = mn;
            if ( ln >= row.length ) break;
        }
        if ( row[hn] == target ) return true;
        return false;
    }
}