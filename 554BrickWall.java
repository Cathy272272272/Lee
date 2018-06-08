class 554BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for ( List<Integer> i: wall ) {
            int l = 0;
            int width = i.size() - 1;
            for ( int j = 0; j < width; j++ ) {
                l += i.get(j);
                map.put(l, map.getOrDefault(l,0) + 1);
            }
        }
        int max = 0;
        int size = wall.size();
        for ( int i : map.values() ) {
            if ( i > max ) 
                max = i;
        }
        return size- max;
    }
}