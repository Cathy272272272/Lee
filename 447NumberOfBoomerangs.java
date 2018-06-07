/* Such a simple question......I am so stupid......
 */
class 447NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if ( n == 1 || n == 2 ) return 0;
        int count = 0, sum = 0, i, j;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for ( i = 0; i < n; i++ ) {
            map.clear();
            for ( j = 0; j < n; j++ ) {
                if ( i == j ) continue;
                int d = distance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for ( int k : map.keySet() ) {
                int val = map.get(k);
                sum += val * ( val - 1);
            }
        }
        return sum;
    }
    public int distance(int[] a, int[] b) {
        return (int)Math.pow(a[0] - b[0], 2) + (int)Math.pow(a[1] - b[1], 2); 
    }
}