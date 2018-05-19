/*
 * class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        return true;
    }
}
*/
class 766ToeplitzMatrix{
    public boolean isToeplitzMatrix(int[][] matrix) {
        int temp, x, y, j;
        if ( matrix.length >= 1 && matrix.length <= 20 && matrix[0].length >= 1 && matrix[0].length <= 20 ){
                // start from the left-bottom corner
                int i = matrix.length - 1;
                for ( j = 0; j < matrix[0].length; j++ )
                    if ( matrix[i][j] <= 99 && matrix[i][j] >= 0 ){
                        x = j;
                        y = i;
                        while ( --x >= 0 && --y >= 0 )
                            if ( matrix[y][x] != matrix[i][j] )
                                return false;      
                    }
                // start from the right-up corner
                i = 0;
                for ( j = matrix[0].length - 1; j >= 0; j-- )
                    if ( matrix[i][j] <= 99 && matrix[i][j] >= 0 ){
                        x = j;
                        y = i;
                        while ( ++x < matrix[0].length && ++y < matrix.length )
                            if ( matrix[y][x] != matrix[i][j] )
                                return false;                         
                    }
            // start from the position below the top-left corner  
            if ( matrix.length > matrix[0].length + 1 ){
                j = 0; 
                for ( i = 1; i < matrix.length - matrix[0].length; i++ )
                    if ( matrix[i][j] <= 99 && matrix[i][j] >= 0 ){
                        x = j;
                        y = i;
                        while ( ++x < matrix[0].length && ++y < matrix.length )
                            if ( matrix[y][x] != matrix[i][j] )
                                return false;
                    }                
            }
        }
        return true;
    }
}