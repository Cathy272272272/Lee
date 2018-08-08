class 839SimilarStringGroups {
    public int numSimilarGroups(String[] A) {
        int n = A.length;
        int[] uf = new int[n];
        Set<Integer> set = new HashSet<>();
        boolean check = false;
        for ( int i = 0; i < n; i++ ) uf[i] = i;
        for ( int i = 0; i < n - 1; i++ ) {
            check = false;
            for ( int j = i + 1; j < n; j++ ) {
                if ( similar(A[i], A[j]) ) {
                    int min = Math.min(uf[i], uf[j]);
                    if ( uf[i] != i || uf[j] != j ) {
                        int tmp = Math.max(uf[i], uf[j]);
                        for ( int k = 0; k < n; k++ ) {
                            uf[k] = uf[k] == tmp ? min : uf[k];
                        }
                    }
                    uf[i] = uf[j] = min;
                }
                else check = true;
            }
            if ( !check ) break;
        }
        for ( int i = 0; i < n; i++ ) {
            set.add(uf[i]);
        }
        return set.size();
    }
    public boolean similar(String a, String b) {
        if ( a.equals(b) ) return true;
        int n = a.length();
        int count = 0;
        for ( int i = 0; i < n; i++ ) {
            if ( a.charAt(i) == b.charAt(i) ) continue;
            count++;
            if ( count == 3 ) return false;
        }
        return true;
    }
}