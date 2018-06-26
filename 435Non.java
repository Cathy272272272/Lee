/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class 435Non-overlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        int n = intervals.length;
        if ( n == 0 || n == 1 ) return 0;
        Arrays.sort(intervals, (x, y) -> {
            int cmp = x.end - y.end;
            if ( cmp == 0 ) cmp = x.start - y.start;
            return cmp;
        });
        int mark = intervals[0].end, count = 1;
        for ( int i = 1; i < n; i++ ) {
            if ( intervals[i].start >= mark ) {
                mark = intervals[i].end;
                count++;
            }
        }
        return n - count ;
    }
}