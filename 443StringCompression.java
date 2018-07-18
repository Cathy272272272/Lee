class 443StringCompression {
    public int compress(char[] chars) {
        int n = chars.length;
        if ( n == 0 ) return 0;
        int count = 1;
        char tmp = chars[0];
        int idx = 0;
        for ( int i = 1; i < n; i++ ) {
            if ( chars[i] == tmp ) count++;
            else {
                chars[idx++] = tmp;
                tmp = chars[i];
                if ( count > 1 ) {
                    String val = String.valueOf(count);
                    int len = val.length();
                    int end = idx + len, start = idx;
                    while ( start < end ) chars[start] = val.charAt(start++ - idx); 
                    idx = end;
                }
                count = 1;
            }
        }
        chars[idx++] = tmp;
        if ( count > 1 ) {
            String val = String.valueOf(count);
            int len = val.length();
            int end = idx + len, start = idx;
            while ( start < end ) chars[start] = val.charAt(start++ - idx); 
            idx = end;
         }
        return idx;
    }
}