class 419BattleshipsInABoard{
    public int countBattleships(char[][] board) {
        int battleships = 0;
        char newboard[][] = new char [board.length + 2][board[0].length + 2];
        for ( int i = 1; i < board.length + 1; i++ )//copy value from board to newboard
            for ( int j = 1; j < board[0].length + 1; j++ )
                newboard[i][j] = board[i - 1][j - 1];
        for ( int i = 1; i < board.length + 1; i++ )
            for ( int j = 1; j < board[0].length + 1; j++ ){
                if ( newboard[i][j] == 'X' ){
                    if ( (newboard[i - 1][j] == 'X' || newboard[i + 1][j] == 'X') && (newboard[i][j - 1] == 'X' || newboard[i][j + 1] == 'X')) //invalid board
                        return 0;
                    else
                        if ( ! (newboard[i - 1][j] == 'X' || newboard[i][j - 1] == 'X' ) )
                            battleships++;    
                }
            }
        return battleships;
    }
}
/*
 * Other better solution
 *     public int countBattleships(char[][] board) {
        int m = board.length;
        if (m==0) return 0;
        int n = board[0].length;
        
        int count=0;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') continue;
                if (j > 0 && board[i][j-1] == 'X') continue;
                count++;
            }
        }
        
        return count;
    }
 */