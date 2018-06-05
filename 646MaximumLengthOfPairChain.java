/*
 * public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, (a,b) -> a[1] - b[1]);
    int sum = 0, n = pairs.length, i = -1;
    while (++i < n) {
        sum++;
        int curEnd = pairs[i][1];
        while (i+1 < n && pairs[i+1][0] <= curEnd) i++;
    }
    return sum;
}
*/
class 646MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        List<List<Integer>> copy = new ArrayList<List<Integer>>();
        List<Integer> tmp, help;
        for ( int[] i : pairs ) {
            tmp = IntStream.of(i).boxed().collect(Collectors.toList());;
            copy.add(tmp);
        }
        Collections.sort(copy, new Comparator<List<Integer>>(){
        //class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            if ( o1.get(1) > o2.get(1) ) return 1;
            if ( o1.get(1) < o2.get(1) ) return -1;
            if ( o1.get(0) > o2.get(0) ) return 1;
            if ( o1.get(0) < o2.get(0) ) return -1;
            return 0;
        }
    });
        tmp = copy.get(0);
        int max = 1;
        for ( int i = 1; i < n; i++ ) {
            help = copy.get(i);
            if ( help.get(0) > tmp.get(1) ) {
                tmp = help;
                max++;
            }
        }
        return max;
    }
}