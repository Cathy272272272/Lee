/*
 * A few of points:

Sort the array according to their end point in ascending order, AND if two intervals have same end, sort them according to their start point in descending order. e.g [[1,5],[4,5],[5,9],[7,9],[9,10]] => [[4,5], [1,5], [7,9], [5,9] , [9,10]]
Greedy to get the rightmost two point
According to the adjustment of the LeetCode admin, this is the accepted version

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int res = 0;
        if (intervals == null || intervals.length == 0) {
            return res;
        }
        Arrays.sort(intervals, (a, b)-> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        // known two rightmost point in the set/res
        int left = intervals[0][1] - 1;
        int right = intervals[0][1];
        res += 2;
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            // 1. one element of the set is in the interval
            // 2. no elemnet of the set is in the interval
            if (left < curr[0] && curr[0] <= right) {
                res++;
                left = right;
                right = curr[1];
            } else if (curr[0] > right) {
                res += 2;
                left = curr[1] - 1;
                right = curr[1];
            }
        }
        return res;
    }
}
The Original problem I contributed asked for all the elements of the qualified set, but the idea is same. This is for original question

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public List<Integer> findSet(List<Interval> intervals) {
        List<Integer> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, (a, b)-> a.end != b.end ? a.end - b.end : b.start - a.start);
        int left = intervals.get(0).end - 1;
        int right = intervals.get(0).end;
        res.add(left);
        res.add(right);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            // 1. one element of the set is in the interval
            // 2. no elemnet of the set is in the interval
            if (left < curr.start && curr.start <= right) {
                res.add(curr.end);
                left = right;
                right = curr.end;
            } else if (curr.start > right) {
                res.add(curr.end - 1);
                res.add(curr.end);
                left = curr.end - 1;
                right = curr.end;
            }
        }
        return res;
    }
Thanks tyuan73 for pointing out the error and providing the case. @tyuan73
@administrators hope adding the case to the test case set at your earliest convenience please, thank you :) [[1,5],[4,5],[5,9],[7,9],[9,10]]
*/
class 757SetIntersectionSizeAtLeastTwo {
    public int intersectionSizeTwo(int[][] itv) {
        int n = itv.length;
        if ( n == 0 ) return 0;
        Arrays.sort(itv, (x, y) -> {
            int cmp = x[1] - y[1];
            if ( cmp == 0 ) cmp = x[0] - y[0];
            return cmp;
        });
        int curmin = itv[0][1] - 1, curmax = itv[0][1], len = 0;
        return help(itv, 1, curmin, curmax);
    }
    public int help(int[][] itv, int idx, int curmin, int curmax) {
        int n = itv.length;
        int len = 0;
        if ( idx == n ) return curmax - curmin + 1;
        for ( int i = idx; i < n; i++ ) {
            if ( itv[i][0] > curmax ) {
                len += curmax - curmin + 1;
                curmin = itv[i][1] - 1;
                curmax = itv[i][1];
            }
            else if ( itv[i][0] == curmax ) {
                if ( i == n - 1 ) return len + curmax - curmin + 2;
                int min = help(itv, i + 1, curmin, curmax + 1);
                int newmin, newmax;
                if ( itv[i+1][1] == itv[i][1] ) {
                    newmin = itv[i][1] - 1;
                    newmax = itv[i][1];
                }
                else {
                    newmin = itv[i][1];
                    newmax = itv[i][1] + 1;
                }
                return len + Math.min(min, curmax - curmin + 1 + help(itv, i + 1, newmin, newmax));
            }
        }
        return len + curmax - curmin + 1;
    }
}