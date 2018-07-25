class 275H-IndexII {
    public int hIndex(int[] c) {
        int n = c.length;
        if ( n == 0 ) return 0;
        int l = 0, h = n - 1, m;
        while ( c[l] == 0 ) {
            l++;
            if ( l == n ) break;
        }
        while ( l < h ) {
            m = ( l + h ) / 2;
            if ( c[m] < n - m ) l = m + 1;
            else h = m;
        }
        return n - l;
    }
}