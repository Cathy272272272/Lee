class 677MapSumPairs {
    private int size;
    private Map<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        size = 0;
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
        size++;
    }
    
    public int sum(String prefix) {
        int sum = 0;
        int length = prefix.length();
        for ( String i : map.keySet() ){
            if (i.length() < length ) continue;
            if ( i.substring(0, length).equals(prefix) ) sum += map.get(i);
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */