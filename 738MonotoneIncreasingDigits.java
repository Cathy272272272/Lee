class 738MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        if ( N / 10 == 0 ) return N;
        StringBuilder n = new StringBuilder(String.valueOf(N));
        int l = n.length(), tmp, j;
        char c;
        for ( int i = l - 1; i > 0; i-- ) {
            c = n.charAt(i);
            if ( c < n.charAt(i-1) ) {
                    for (  j = i; j < l; j++ ) n.setCharAt(j, '9');
                    if ( n.charAt(i-1) - '1' == 0 ) {
                        if ( i == 1 ) return Integer.parseInt(n.substring(1));
                        n.setCharAt(i-1, '9');
                        for (  j = i - 2; j > 0; j-- ) {
                            if ( n.charAt(j) - '1' > 0 ) {
                                if ( j == 0 ) { 
                                    n.setCharAt(j, (char)(n.charAt(j) - 1));
                                    return Integer.parseInt(n.toString());
                                }
                                else {
                                    if ( n.charAt(j-1) > n.charAt(j) - 1 ) {
                                        n.setCharAt(j, '9');
                                        n.setCharAt(j-1, (char)(n.charAt(j-1) - 1));
                                    }
                                    else n.setCharAt(j, (char)(n.charAt(j) - 1));
                                }
                                break;
                            }
                            n.setCharAt(j, '9');
                        }
                        if ( j == 0 ) {
                            if ( n.charAt(0) == '1')
                            return Integer.parseInt(n.substring(1));
                            else {
                                n.setCharAt(0, (char)(n.charAt(0) - 1));         
                                return Integer.parseInt(n.toString());
                            }
                        }
                    }
                    else n.setCharAt(i-1, (char)(n.charAt(i-1) - 1));
            }
        }
        return Integer.parseInt(n.toString());
    }
}