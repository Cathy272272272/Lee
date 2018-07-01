class 838PushDominoes {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int i = 0, tmp = 0, markl= -1, markll = -1, markr = -1, markrr = -1;
        boolean first = false, second = false, left = false, right = false;
        StringBuilder ans = new StringBuilder();
        while ( i < n ) {
            if ( !left && !right ) {
                if ( dominoes.charAt(i) == 'L' ) {
                    left = true;
                    markl = i;
                    markll = i;
                }
                if ( dominoes.charAt(i) == 'R' ) {
                    right = true;
                    markr = i;
                    markrr = i;
                    add(ans, 0, i-1, '.');
                }
            }
            else if ( left && !right ) {
                if ( dominoes.charAt(i) == 'L' ) markll = i;
                if ( dominoes.charAt(i) == 'R' ) {
                    if ( markr == -1 ) {
                        add(ans, 0, markll, 'L');
                        add(ans, markll + 1, i - 1, '.');
                    }
                    else {
                        tmp = (markl - markrr - 1) / 2;
                        add(ans, markr, markrr - 1, 'R');
                        add(ans, markrr, markrr + tmp, 'R');
                        if ( tmp * 2 < markl - markrr - 1) ans.append('.');
                        add(ans, markl - tmp, markll, 'L');
                        add(ans, markll + 1, i - 1, '.');
                    }
                    right = true;
                    left = false;
                    markr = i;
                    markrr = i;
                }                
            }
            else if ( !left && right ) {
                if ( dominoes.charAt(i) == 'R' ) markrr = i;
                if ( dominoes.charAt(i) == 'L' ) {
                    markl = i;
                    markll = i;
                    left = true;
                    right = false;
                } 
            }
            i++;
        }
        if ( !right && !left ) return dominoes;
        if ( right ) add(ans, markr, n-1, 'R');
        else {
            if ( markr ==-1 ) {
                add(ans, 0, markll, 'L');
                add(ans, markll + 1, i - 1, '.');
            }
            else {
                tmp = (markl - markrr - 1) / 2;
                add(ans, markr, markrr - 1, 'R');
                add(ans, markrr, markrr + tmp, 'R');
                if ( tmp * 2 < markl - markrr - 1) ans.append('.');
                add(ans, markl - tmp, markll, 'L');
                add(ans, markll + 1, n - 1, '.');
            }           
        }
        return ans.toString();
    }
    public void add(StringBuilder ans, int i, int j, char c) {
        while ( i++ <= j ) ans.append(c);
    }
}