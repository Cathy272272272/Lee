class 769MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int length = arr.length;
        int max = 0;
        for ( int i = 0; i < length; i++ ) {
            if ( arr[i] == i ) res++;
            else {
                max = arr[i];
                i++;
                while ( i <= max ) {
                    if ( arr[i] > max )
                        max = arr[i];
                    i++;
                }
                i--;
                res++;
            }
        }
        return res;
    }
}