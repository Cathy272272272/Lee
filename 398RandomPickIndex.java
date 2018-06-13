/*
 * 
 *
 * These lines are faster and clever...
 * for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }
 */
     
 /*
  * 
 
 * public class Solution {

    int[] nums;
    Random rnd;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }
    
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)
                result = i;
        }
        
        return result;
    }
}
*/
class 398RandomPickIndex {
    int[] sol;
    int n;
    public Solution(int[] nums) {
        n = nums.length;
        sol = new int[n];
        for ( int i = 0; i < n; i++ )
            sol[i] = nums[i];
    }
    
    public int pick(int target) {
        List<Integer> list = new ArrayList<Integer>();
        for ( int i = 0; i < n; i++ ) 
           if ( target == sol[i] ) 
               list.add(i);
        Random ran = new Random();
        return list.get(ran.nextInt(list.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */