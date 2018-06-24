/*
 * Basically, this solution follows the idea of the mathematical formula C(n,k)=C(n-1,k-1)+C(n-1,k).

Here C(n,k) is divided into two situations. Situation one, number n is selected, so we only need to select k-1 from n-1 next. Situation two, number n is not selected, and the rest job is selecting k from n-1.

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = this.combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(this.combine(n - 1, k));
        return result;
    }
}
*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<List<Integer>> help = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        if ( k == 0 || n < k ) return list;
        if ( k == 1 ) {
            for ( int i = 1; i <= n; i++ ) { 
                tmp = new ArrayList<Integer>();
                tmp.add(i);
                list.add(tmp);
            }
            return list;
        }
        for ( int i = k; i <= n; i++ ) {
            help = new ArrayList<List<Integer>>();
            help = combine(i - 1, k - 1);
            for( List<Integer> j : help ) {
                tmp = new ArrayList<Integer>();
                tmp = j;
                tmp.add(i);
                list.add(tmp);
            }
        }
        return list;
    }
}