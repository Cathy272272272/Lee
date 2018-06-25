/*
 * public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        java.util.NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();
        
        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i].start, i);    
        }
        
        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }
        
        return result;
    }
}
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class 436FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        List<Interval> list = new ArrayList<>();
        List<Interval> help = new ArrayList<>();
        for ( Interval i : intervals ) { list.add(i); help.add(i);}
        Collections.sort(list, (x, y) -> {
            int cmp = x.start - y.start;
            if ( cmp == 0 ) cmp = x.end - y.end;
            return cmp;
        });
        int l = intervals.length;
        int[] res = new int[l];
        int index, end, start, mark;
        Interval tmp, min;
        boolean first;
        for ( int i = 0; i < l; i++ ) {
            index = list.indexOf(intervals[i]) + 1;
            if ( index == l ) { res[i] = -1; continue;}
            tmp = list.get(index);
            end = intervals[i].end;
            first = false;
            while ( index < l ) {
                tmp = list.get(index);
                if ( tmp.start >= end ) {
                    first = true;
                    break;
                }
                index++;
            }
            if ( first ) res[i] = help.indexOf(tmp);
            else res[i] = -1;
        }
        return res;
    }
}