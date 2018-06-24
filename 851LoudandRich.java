class 851LoudandRich {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int q = quiet.length;
        if ( q < 1 || q > 500 ) return new int[q];
        int r = richer.length;
        if ( r < 0 || r > q*(q-1)/2 ) return new int[q];
        int qu;
        int[] res = new int[q];
        for ( int i = 0; i < q; i++ ) res[i] = add(i, richer, quiet);
        return res;
    }
    public int add(int i, int[][]r, int[] quiet ) {
        if ( map.containsKey(i)) return map.get(i);
        int qu = i, min = quiet[i], tmp;
        for ( int[] j : r ) {
            if ( j[1] == i ) {
                if ( !map.containsKey(j[0]) ) map.put(j[0], add(j[0], r, quiet));
                tmp = quiet[map.get(j[0])];
                if ( tmp < min ) { qu = map.get(j[0]); min = tmp; }
            }
        }
        map.put(i, qu);
        return qu;
    }
}