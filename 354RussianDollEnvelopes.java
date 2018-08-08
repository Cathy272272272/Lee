/*
 * public int maxEnvelopes(int[][] envelopes) {
    if(envelopes == null || envelopes.length == 0 
       || envelopes[0] == null || envelopes[0].length != 2)
        return 0;
    Arrays.sort(envelopes, new Comparator<int[]>(){
        public int compare(int[] arr1, int[] arr2){
            if(arr1[0] == arr2[0])
                return arr2[1] - arr1[1];
            else
                return arr1[0] - arr2[0];
       } 
    });
    int dp[] = new int[envelopes.length];
    int len = 0;
    for(int[] envelope : envelopes){
        int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
        if(index < 0)
            index = -(index + 1);
        dp[index] = envelope[1];
        if(index == len)
            len++;
    }
    return len;
}
*/
class 354RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if ( n == 0 ) return 0;
        Arrays.sort(envelopes, (x, y) -> {
            int cmp = x[0] - y[0];
            if ( cmp == 0 ) cmp = x[1] - y[1];
            return cmp;
        });
        int[] dp = new int[n];
        int max = 0;
        for ( int i = 0; i < n - 1; i++ ) max = Math.max(max, help(envelopes, dp, i+1, i));
        return 1 + max;
    }
    public int help(int[][] e, int[] dp, int idx, int cur) {
        int n = e.length;
        if ( idx >= n ) return 0;
        if ( dp[idx - 1] != 0 ) return dp[idx - 1];
        int count = 0;
        for ( int i = idx; i < n; i++ ) {
            if ( e[i][0] > e[cur][0] && e[i][1] > e[cur][1] ) count = Math.max(count, 1 + help(e, dp, i + 1, i));
        }
        dp[idx - 1] = count;
        return count;
    }
}