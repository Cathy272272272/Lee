/*Can be O(1) space
 * public int rob(int[] num) {
    int prevNo = 0;
    int prevYes = 0;
    for (int n : num) {
        int temp = prevNo;
        prevNo = Math.max(prevNo, prevYes);
        prevYes = n + temp;
    }
    return Math.max(prevNo, prevYes);
}
*/
class 198HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if ( n == 0 ) return 0;
        if ( n == 1 ) return nums[0];
        int[] dp = new int[n+1];
        int max = 0;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for ( int i = 2; i < n; i++ ) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]); 
        }
        return dp[n-1];
    }
}