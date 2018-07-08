class 459RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int c = 0, n = s.length();
        if ( n == 0 || n == 1) return false;
        int i = 2;
        char tmp;
        while ( i < n / 2 ) {
            if ( n % i == 0 ) break;
            i++;
        }
        if ( (i == n / 2 && n != 4) || n <= 3 ) {
            tmp = s.charAt(0);
            for ( char j : s.toCharArray()) if ( j != tmp ) return false;
            return true;
        }
        String cmp = s.substring(0, i);
        int l = i, j = i;
        while ( j < n ) {if (!s.substring(j, j+l).equals(cmp)) break; j += l;}
        if ( j == n ) return true;
        l = n/i;
        cmp = s.substring(0, l);
        j = l;
        while ( j < n ) {if (!s.substring(j, j+l).equals(cmp)) return false; j += l;}
        return true;
    }
}