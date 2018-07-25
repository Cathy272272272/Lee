class 433MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        int n = bank.length;
        if ( n == 0 ) return -1;
        if ( start.equals(end)) return 0;
        boolean[] v = new boolean[n];
        int ans = help(start, end, bank, v);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int help(String start, String end, String[] bank, boolean[] v) {
        int n = bank.length;
        if ( n == 0 ) return 0;
        if ( start.equals(end)) return 0;
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for ( String i : bank ) {
            if ( v[idx++] ) continue;
            int count = 0;
            boolean OK = true;
            for ( int j = 0; j < 8; j++ ) {
                if ( i.charAt(j) != start.charAt(j) ) count++;
                if ( count == 2 ) {
                    OK = false;
                    break;
                }
            }
            if ( OK ) {
                v[idx - 1] = true;
                int ans = help(i, end, bank, v);
                v[idx - 1] = false;
                if ( ans != Integer.MAX_VALUE ) min = Math.min(min, ans + 1);
            }
        }
        return min;
    }
}