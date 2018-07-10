class 289GameofLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if ( m == 0 ) return;
        int n = board[0].length;
        if ( n == 0 ) return;
        int count;
        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                count = 0;
                if ( board[i][j] == 0 ) {
                    for ( int r = -1; r < 2; r++ ) {
                        for ( int c = -1; c < 2; c++ ) {
                            if( r == 0 && c == 0 ) continue;
                            if ( r + i >= 0 && r + i < m && j + c >= 0 && j + c < n ) {
                                if ( board[r+i][j+c] == 1 || board[r+i][j+c] == 3 ) count++;
                            }
                        }
                    }
                    // 0 in cur state, 1 in next state
                    if ( count == 3 ) board[i][j] = 2;
                }
                else {
                    for ( int r = -1; r < 2; r++ ) {
                        for ( int c = -1; c < 2; c++ ) {
                            if( r == 0 && c == 0 ) continue;
                            if ( r + i >= 0 && r + i < m && j + c >= 0 && j + c < n ) {
                                if ( board[r+i][j+c] == 1 || board[r+i][j+c] == 3 ) count++;
                            }
                        }
                    }
                    // 1 in cur state, 0 in next state
                    if ( count < 2 || count > 3 ) board[i][j] = 3;                    
                }
            }
        }
        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                if ( board[i][j] == 2 ) board[i][j] = 1;
                if ( board[i][j] == 3 ) board[i][j] = 0;
            }
        }
    }
}