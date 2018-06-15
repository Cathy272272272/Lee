class 541ReverseStringII {
    public String reverseStr(String s, int k) {
        int n = s.length();
        if ( k == 0 ) return null;
        int p = n / k / 2, i;
        StringBuilder tmp;
        StringBuilder res = new StringBuilder();
        for ( i = 0; i < p; i++ ) {
            tmp = new StringBuilder(s.substring(i*2*k, i*2*k + k));
            tmp.reverse();
            res.append(tmp).append(s.substring(i*2*k+k,(i+1)*2*k));
        }
        if ( n - k * p * 2 < k ) {
            tmp = new StringBuilder(s.substring(i*2*k, n));
            tmp.reverse();
            res.append(tmp); 
        }
        else {
            tmp = new StringBuilder(s.substring(i*2*k, i*2*k + k));
            tmp.reverse();
            res.append(tmp).append(s.substring(i*2*k+k, n));
        }
        return res.toString();
    }
}