class 529Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        char[][] out = board;
        int[] help = new int[2];
        if ( board.length < 1 || board.length > 50 ) return null;
        if ( board[0].length < 1 || board[0].length > 50 ) return null;
        int count = 0;
        for ( int i = click[0] - 1; i <= click[0] + 1; i++ ) 
            for ( int j = click[1] - 1; j <= click[1] + 1; j++ ) 
                if ( i >= 0 && i < board.length && j >= 0 && j < board[0].length ) 
                    if ( board[i][j] == 'M' ) 
                        if ( i == click[0] && j == click[1] ) {
                            board[click[0]][click[1]] = 'X';
                            return board;
                        }
                        else
                            count++;
        if ( count == 0 ) {
            out[click[0]][click[1]] = 'B';
            for ( int i = click[0] - 1; i <= click[0] + 1; i++ ) 
                for ( int j = click[1] - 1; j <= click[1] + 1; j++ ) 
                    if ( i >= 0 && i < board.length && j >= 0 && j < board[0].length && out[i][j] == 'E' ) {
                        help[0] = i;
                        help[1] = j;
                        out = updateBoard(out, help);
                    }
            return out;
        }
        else
            board[click[0]][click[1]] = (char)(count + '0');
        return board;
    }
}