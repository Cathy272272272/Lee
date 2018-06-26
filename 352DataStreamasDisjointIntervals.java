/*
 * Use TreeMap to easily find the lower and higher keys, the key is the start of the interval.
Merge the lower and higher intervals when necessary. The time complexity for adding is O(logN) since lowerKey(), higherKey(), put() and remove() are all O(logN). It would be O(N) if you use an ArrayList and remove an interval from it.

public class SummaryRanges {
    TreeMap<Integer, Interval> tree;

    public SummaryRanges() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if(tree.containsKey(val)) return;
        Integer l = tree.lowerKey(val);
        Integer h = tree.higherKey(val);
        if(l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {
            tree.get(l).end = tree.get(h).end;
            tree.remove(h);
        } else if(l != null && tree.get(l).end + 1 >= val) {
            tree.get(l).end = Math.max(tree.get(l).end, val);
        } else if(h != null && h == val + 1) {
            tree.put(val, new Interval(val, tree.get(h).end));
            tree.remove(h);
        } else {
            tree.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(tree.values());
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
class 352DataStreamasDisjointIntervals {
    List<Interval> list;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        list = new ArrayList<Interval>();
    }
    
    public void addNum(int val) {
        if ( list.size() == 0 ) {
            list.add(new Interval(val, val));
            return;
        }
        int n = list.size();
        for ( int i = 0; i < n; i++ ) {
            if ( val == list.get(i).start - 1 ) {
                list.add(i, new Interval(val, list.get(i).end));
                list.remove(i+1);
                break;
            }
            if ( val == list.get(i).end + 1 ) { 
                if ( i != n - 1 ) {
                    if ( list.get(i+1).start == val + 1 ) {
                        list.add(i, new Interval(list.get(i).start, list.get(i+1).end));
                        list.remove(i+1);
                        list.remove(i+1);
                    }
                    else {
                        list.add(i, new Interval(list.get(i).start, val));
                        list.remove(i+1);                        
                    }
                }
                else {
                    list.add(i, new Interval(list.get(i).start, val));
                    list.remove(i+1);
                }
                break;
            }
        if ( i == 0 ) {
            if ( val < list.get(i).start - 1 ) {
                list.add(0, new Interval(val, val));
                break;
            }
            if ( n == 1 )
                if ( val > list.get(i).end + 1 ) {
                    list.add(n, new Interval(val, val));
                    break;                
            }
        }
        else {
            if ( val > list.get(i - 1).end + 1 && val < list.get(i).start - 1 ) {
                list.add(i, new Interval(val, val));
                break;
            }
            if ( i == n - 1 ) {
                if ( val > list.get(i).end + 1 ) {
                list.add(n, new Interval(val, val));
                break;                
            }
            }
        }
    }
}
    
    public List<Interval> getIntervals() {
        return list;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */