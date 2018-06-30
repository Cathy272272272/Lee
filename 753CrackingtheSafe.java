class 753CrackingtheSafe {
    public String crackSafe(int n, int k) {
        StringBuilder out = new StringBuilder();
        if ( n == 1 ) {
            for ( int i = 0; i < k; i++ ) out.append(i);
            return out.toString();
        }
        if ( k == 1 ) {
            for ( int i = 0; i < n; i++ ) out.append("0");
            return out.toString();
        }
        StringBuilder tmp0 = new StringBuilder();
        StringBuilder tmp1 = new StringBuilder();
        StringBuilder tmp2 = new StringBuilder();
        int help = (int)Math.pow(k, n-1);
        for ( int i = 0; i < k; i++ ) {
            tmp0.append(i);
            for ( int j = 0; j < help; j++ ) 
                tmp1.append(i);
        }
        for ( int i = 0; i < help; i++) tmp2.append(tmp0);
        int tmp, count = 0, mark;
        int[] res = new int[k*help];
        for ( int i = 0; i < k; i++ ) {
            tmp = i * help;
            for ( int j = 0; j < help; j++ ) {
                res[count] = (count - tmp) * k + i;
                count++;
            }
        }
        int[] useful = new int[k*help];
        boolean[] visited = new boolean[k*help];
        int j;
        count = 0;
        for ( int i = 0; i < k*help; i++ ) {
            if ( visited[i] ) continue;
            visited[i] = true;
            useful[count] = i;
            out.append(tmp1.charAt(i));
            count++;
            j = res[i];
            while( j != i ) {
                visited[j] = true;
                useful[count] = j;
                out.append(tmp1.charAt(j));
                count++;
                j = res[j]; 
            }
        }
        for ( int i = 0; i < n-1;i++)out.append("0");
        return out.toString();
    }
}