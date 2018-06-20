class 621TaskScheduler{
    public int leastInterval(char[] tasks, int n) {
        int[] a = new int[26];
        int res = 0;
        for ( char c : tasks ) { res++; a[c - 'A']++;}
        Arrays.sort(a);
        int size = a.length;
        int rec = (n+1)*(a[size-1] -1);
        for ( int i = (size - 1 - n > 0 ? size - 1 - n : 0 ); i < size; i++ ) rec += ( a[i] == a[size-1] ? 1 : 0 );
        return Math.max(rec, res);
    }
}