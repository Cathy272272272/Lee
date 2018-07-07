class 849MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int min = 0, n = seats.length, prev = -1;
        for ( int i = 0; i < n; i++ ) {
            if ( seats[i] == 1 ) {
                if ( prev == -1 ) {
                    min = i;
                    prev = i;
                }
                else {
                    min = Math.max((i - prev) / 2, min);
                    prev = i;
            }
        }
        }
        min = Math.max(min, n - 1 - prev);
        return min;
    }
}