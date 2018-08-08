class 680ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int n = s.length();
        if ( n <= 1 ) return true;
        int l = 0, h = n - 1;
        while ( l < h ) if ( s.charAt(l++) != s.charAt(h--) ) return palin(s.substring(l, h+2)) || palin(s.substring(l-1, h+1));
        return true;
        
    }
    public boolean palin(String s) {
        int n = s.length();
        if ( n <= 1 ) return true;
        int l = 0, h = n - 1;
        while ( l < h ) if ( s.charAt(l++) != s.charAt(h--) ) return false;
        return true;
    }
}