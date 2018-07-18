/*
 * Use an extra boolean array " boolean[] used" to indicate whether the value is added to list.

Sort the array "int[] nums" to make sure we can skip the same value.

when a number has the same value with its previous, we can use this number only if his previous is used

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}
*/
class 47PermutationsII {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        //Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for ( int i : nums ) list.add(i);
        help(list, 0);
        return ans;
    }
    public void help(List<Integer> list, int i) {
        int n = list.size();
        int t = list.get(i);
        if ( ans.contains(list) ) return;
        ans.add(list);
        for ( int j = i + 1; j < n; j++ ) {
            help(list, j);
            if ( list.get(j) == list.get(i)) continue;
            List<Integer> tmp = new ArrayList<>(list);
            tmp.set(i, list.get(j));
            tmp.set(j, t);
            help(tmp, 0);
        }
    }
}