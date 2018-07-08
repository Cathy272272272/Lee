class 731MyCalendarII {
    TreeMap<Integer, Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
        TreeMap<Integer, Integer> help = new TreeMap<Integer, Integer>(map);
        Integer lk = map.floorKey(start);
        int tmp;
        if ( lk == null) map.put(start, 1);
        else {
            tmp = map.get(lk);
            if ( tmp == 2 ) return false;
            map.put(start, tmp + 1);
        }
        Integer key = map.higherKey(start);
        if ( key == null ) {
            map.put(end, 0);
            return true;
        }
        while ( key < end ) {
            tmp = map.get(key);
            //System.out.println(key + " " + tmp);
            if ( tmp == 2 ) {
                map = new TreeMap<Integer, Integer>(help);
                return false;
            }
            map.put(key, tmp + 1);
            key = map.higherKey(key);
            if ( key == null ) {
                map.put(end, 0);
                return true;
            }
        }
        if ( map.get(end) == null ) map.put(end, map.get(map.lowerKey(end)) - 1);
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */