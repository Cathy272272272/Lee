class 598RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        if ( ops.length > 10000 || m > 40000 || m < 1 || n > 40000 || n < 1 ) return 0;
        if ( ops.length == 0 ) return m*n;
        
        int minY = ops[0][0];
        int minX = ops[0][1];
        for ( int[] i : ops ) {
            if ( i[0] < 1 || i[0] > m || i[1] < 1 || i[1] > n ) return 0;
            if ( minY > i[0] ) 
                minY = i[0];
            if ( minX > i[1] )
                minX = i[1];
        }
        return minX * minY;
    }
}