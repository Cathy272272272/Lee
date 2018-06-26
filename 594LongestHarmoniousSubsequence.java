class 594LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for ( int i : nums ) map.put(i, map.getOrDefault(i, 0) + 1);
        int max = 0, size = map.size(), key;
        if ( size == 0 || size == 1) return 0;
        int prev = map.firstKey(), tmp;
        for( int i = 1; i < size; i++ ) {
            key = map.higherKey(prev);
            if ( prev == key - 1 ) {
                tmp = map.get(prev) + map.get(key);
                if ( max < tmp ) max = tmp;
            }
            prev = key;
        }
        return max;
    }
}