/*
 * Use DP to track max Set and pre index.

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        Arrays.sort(nums);
        int max = 0, index = -1;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + count[j] > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
*/
class 368LargestDivisibleSubset {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();
        int n = nums.length;
        for ( int i = 0; i < n; i++ ) {
            cur.add(nums[i]);
            help(nums, i, cur);
            cur.remove(cur.size() - 1);
            if ( ans.size() == n ) return ans;
        }
        return ans;
    }
    public void help(int[] nums, int idx, List<Integer> cur) {
        int n = nums.length;
        if ( idx == n - 1 ) {
            if ( cur.size() > ans.size() ) 
                ans = new ArrayList<Integer>(cur);
            return;
        }
        boolean check = false;
        for ( int i = idx + 1; i < n; i++ ) {
            if ( nums[i] % nums[idx] == 0 ) {
                check = true;
                cur.add(nums[i]);
                help(nums, i, cur);
                if ( ans.size() == n ) return;
                cur.remove(cur.size() - 1);
            }
        }
        if ( !check ) {
            if ( cur.size() > ans.size() ) 
                ans = new ArrayList<Integer>(cur);            
        }
    }
}