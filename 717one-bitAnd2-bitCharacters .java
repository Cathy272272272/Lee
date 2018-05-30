class 717one-bitAnd2-bitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if ( n > 1000 || n < 1 ) return false;
        int start = n - 1;
        while (bits[start] != 1 ){
            start--;
            if ( start == -1 )
                break;
        }
        if ( start != -1 ) {
        int mark = start;
        while ( bits[start] == 1 ) {
            start--;
            if ( start == -1 )
                break;
        }
        if ( (mark - start) % 2 == 0 ) return true;
        else {
                if ( n - 1 - mark > 1 ) return true;
                else return false;
            }
        }
        return true;
    }
}