class 828UniqueLetterString {
    public int uniqueLetterString(String S) {
        int n = S.length();
        int[] a = new int[26];
        int[][] pre = new int[26][2];
        int count = 0;
        for ( int i = 0; i < n; i++ ) {
            int tmp = S.charAt(i) - 'A';
            a[tmp]++;
            //count += (n - i + 1) * ( n - i ) / 2;
            count += ( i + 1 ) * ( n - i );
            if ( a[tmp] == 1 ) pre[tmp][0] = i;
            if ( a[tmp] > 1 ) {
                //int idx = S.substring(0, i).lastIndexOf(S.charAt(i));
                //int lastidx = S.substring(0, idx).lastIndexOf(S.charAt(i));
                if ( a[tmp] == 2 ) {
                    count -=  2 * ( n - i ) * ( pre[tmp][0] + 1 );
                    pre[tmp][1] = i;
                }
                else {
                    count -= ( n - i ) * ( pre[tmp][0] + 1 );
                    count -= 2 * ( n - i ) * ( pre[tmp][1] - pre[tmp][0] );
                    pre[tmp][0] = pre[tmp][1];
                    pre[tmp][1] = i;
                }

            }
        }
        return count;
    }
}