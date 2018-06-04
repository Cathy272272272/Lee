/* At first I used list, very slow......
 * 
 */
 class 454FourSumII {
    int sum = 0;
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> AB = new HashMap<Integer, Integer>();
        Map<Integer, Integer> CD = new HashMap<Integer, Integer>();
        for ( int i: A )
            for ( int j : B )
                AB.put(i+j,AB.getOrDefault(i+j, 0) + 1);
        for ( int i: C )
            for ( int j : D )
                CD.put(i+j,CD.getOrDefault(i+j, 0) + 1);
        for ( int i : AB.keySet() ) {
            if ( CD.containsKey(-i) )
                sum += AB.get(i) * CD.get(-i);
        }  
        return sum;
}