// Mine is O(nlogn), the one is O(n)...
/* 
 * public int hIndex(int[] citations) {
    int n = citations.length;
    int[] buckets = new int[n+1];
    for(int c : citations) {
        if(c >= n) {
            buckets[n]++;
        } else {
            buckets[c]++;
        }
    }
    int count = 0;
    for(int i = n; i >= 0; i--) {
        count += buckets[i];
        if(count >= i) {
            return i;
        }
    }
    return 0;
}
*/
class 274H-Index {
    public int hIndex(int[] cit) {
        int n = cit.length;
        if ( n == 0 ) return 0;
        Arrays.sort(cit);
        for ( int i = 0; i < n; i++ ) {
            if ( cit[i] >= n - i ) return n - i;
        }
        return 0;
    }
}