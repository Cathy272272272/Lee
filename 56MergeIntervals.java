/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        List<Interval> ans = new ArrayList<>();
        if ( n == 0 ) return ans;
        Collections.sort(intervals, (x, y) -> {
            int cmp = x.start - y.start;
            if ( cmp == 0 ) cmp = y.end - x.end;
            return cmp;
        });
        Interval cur = intervals.get(0);
        for ( int i = 1; i < n; i++ ) {
            Interval tmp = intervals.get(i);
            if ( tmp.start > cur.end ) {
                ans.add(new Interval(cur.start, cur.end));
                cur = tmp;
                continue;
            }
            if ( tmp.end > cur.end ) cur.end = tmp.end;
        }
        ans.add(cur);
        return ans;
    }
}