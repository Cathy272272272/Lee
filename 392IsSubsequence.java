class 392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int ss = s.length(), tt = t .length();
        if ( ss > tt || ss > 100 ) return false;
        int j = 0, tmp = 0;
        for ( int i = 0; i < ss; i++ ) {
            tmp = t.indexOf(s.charAt(i), j);
            if ( tmp < 0 ) return false;
            j = tmp + 1;
        }
        return true;
    }
}