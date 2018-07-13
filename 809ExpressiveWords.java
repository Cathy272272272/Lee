class 809ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int n = S.length();
        if ( n == 0 ) return 0;
        int[] a = new int[26];
        StringBuilder t = new StringBuilder();
        char tmp = S.charAt(0);
        int count = 1, mark = 0;
        for ( int i = 1; i < n; i++ ) {
            if ( S.charAt(i) == tmp ) count++;
            else {
                if ( count < 3 ) t.append(S.substring(mark, i));
                else t.append(S.charAt(mark));
                mark = i;
                count = 1;
                tmp = S.charAt(i);
            }
        }
        if ( count < 3 ) t.append(S.substring(mark));
        else t.append(S.charAt(mark));
        String cmp = t.toString();
        int ans = 0;
        for ( String i : words ) {
            if(help(i, cmp, S)) ans++;
        }
        return ans;
    }
    public boolean help(String s, String cmp, String ori) {
        int n = s.length();
        int c = cmp.length();
        int o = ori.length();
        if ( n == 0 && c == 0 ) return true;
        if ( n == 0 || c == 0 ) return false;
        if ( s.equals(cmp) ) return true;
        char tmp = cmp.charAt(0);
        if ( s.charAt(0) != tmp ) return false;
        int count1 = 1, count2 = 1, count3 = 1;
        boolean cmpcheck = false, scheck = false;
        for ( int i = 1; i < o; i++ ) {
            if ( i < c ) {
                if ( !cmpcheck && cmp.charAt(i) == tmp ) count1++;
                else cmpcheck = true;
            }
            if ( i < n ) {
                if ( !scheck && s.charAt(i) == tmp ) count3++;
                else scheck = true;
            }
            if ( ori.charAt(i) == tmp ) count2++;
            else break;
        }
        if ( (!scheck && count3 < n ) || count1 > count3 ) return false;
        return help(s.substring(count3), cmp.substring(count1), ori.substring(count2));
    }
}