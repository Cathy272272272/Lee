class 667BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int[] large = new int[n];
        int help = n - 1;
        large[0] = 1;
        int i;
        if ( k == 1 ){
            for ( i = 1; i < n; i++ ) large[i] = i + 1;
            return large;
        }
        for ( i = 1; i < k; i++ ){
            if ( i % 2 == 1 ) large[i] = large[i - 1] + help;
            else large[i] = large[i - 1] - help;
            help--;
        }
        int mark;
        if ( large[i - 1] < large[i - 2] ) mark = 1;
        else mark = -1;
        for ( int j = i; j < n; j++ ) large[j] = large[j - 1] + mark;
        return large;
    }
}