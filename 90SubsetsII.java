/*
 * public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> each = new ArrayList<>();
    helper(res, each, 0, nums);
    return res;
}
public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
    if (pos <= n.length) {
        res.add(each);
    }
    int i = pos;
    while (i < n.length) {
        each.add(n[i]);
        helper(res, new ArrayList<>(each), i + 1, n);
        each.remove(each.size() - 1);
        i++;
        while (i < n.length && n[i] == n[i - 1]) {i++;}
    }
    return;
}
The Basic idea is: use "while (i < n.length && n[i] == n[i - 1]) {i++;}" to avoid the duplicate. For example, the input is 2 2 2 3 4. Consider the helper function. The process is:

each.add(n[i]); --> add first 2 (index 0)
helper(res, new ArrayList<>(each), i + 1, n); --> go to recursion part, list each is <2 (index 0)>
while (i < n.length && n[i] == n[i - 1]) {i++;} --> after this, i == 3, add the element as in subset I
*/
class 90SubsetsII {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> tmp;
        int n = nums.length;
        if ( n == 0 ) return list;
        Arrays.sort(nums);
        list.add(new ArrayList<Integer>());
        tmp = new ArrayList<Integer>();
        tmp.add(nums[0]);
        help(nums, 0, tmp);
        return list;
    }
    public void help(int[] nums, int i, List<Integer> cur) {
        int n = nums.length;
        if ( i == n ) return;
        List<Integer> tmp;
        if ( !list.contains(cur)) list.add(cur);
        for ( int j = i + 1; j < n; j++ ) {
            tmp = new ArrayList<Integer>(cur);
            tmp.remove(tmp.size() - 1);
            tmp.add(nums[j]);
            help(nums, j, tmp);
            cur = new ArrayList<Integer>(cur);
            cur.add(nums[j]);
            help(nums, j, cur);
        }
    }
}