class 658FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        if ( n == 0 || k > n ) return list;
        if ( arr[0] >= x ) {
            for ( int i = 0; i < k; i++ ) list.add(arr[i]);
            return list;
        }
        if ( arr[n-1] <= x ) {
            for ( int i = n-k; i < n; i++ ) list.add(arr[i]);
            return list;
        }
        int l = 0, h = n-1;
        while ( l < h ) {
            int m = (l+h)/2;
            if ( arr[m] >= x ) h = m;
            else l = m + 1;
        }
        int s, e, r;
        if ( arr[l] == x ) {
            list.add(x);
            if ( k == 1 ) return list;
            s = l - 1;
            e = l + 1;
            if ( e < n ) r = arr[e] - x;
            else r = Integer.MAX_VALUE;
            if ( s >= 0 ) l = x - arr[s];
            else l = Integer.MAX_VALUE;
        }
        else {
            s = l - 1;
            e = l;
            if ( e < n ) r = arr[e] - x;
            else r = Integer.MAX_VALUE;
            if ( s >= 0 ) l = x - arr[s];
            else l = Integer.MAX_VALUE;
        }
        while ( list.size() < k ) {
            if ( l <= r ) {
                list.add(0, arr[s--]);
                if ( s >= 0 ) l = x - arr[s];
                else l = Integer.MAX_VALUE;
            }
            else {
                list.add(arr[e++]);
                if ( e < n ) r = arr[e] - x;
                else r = Integer.MAX_VALUE;
            }
        }
        return list;
    }
}