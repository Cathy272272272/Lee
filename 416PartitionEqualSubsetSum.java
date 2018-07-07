/*
 * This problem is essentially let us to find whether there are several numbers in a set which are able to sum to a specific value (in this problem, the value is sum/2).

Actually, this is a 0/1 knapsack problem, for each number, we can pick it or not. Let us assume dp[i][j] means whether the specific sum j can be gotten from the first i numbers. If we can pick such a series of numbers from 0-i whose sum is j, dp[i][j] is true, otherwise it is false.

Base case: dp[0][0] is true; (zero number consists of sum 0 is true)

Transition function: For each number, if we don't pick it, dp[i][j] = dp[i-1][j], which means if the first i-1 elements has made it to j, dp[i][j] would also make it to j (we can just ignore nums[i]). If we pick nums[i]. dp[i][j] = dp[i-1][j-nums[i]], which represents that j is composed of the current value nums[i] and the remaining composed of other previous numbers. Thus, the transition function is dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]

talking is cheap:

public boolean canPartition(int[] nums) {
    int sum = 0;
    
    for (int num : nums) {
        sum += num;
    }
    
    if ((sum & 1) == 1) {
        return false;
    }
    sum /= 2;

    int n = nums.length;
    boolean[][] dp = new boolean[n+1][sum+1];
    for (int i = 0; i < dp.length; i++) {
        Arrays.fill(dp[i], false);
    }
    
    dp[0][0] = true;
    
    for (int i = 1; i < n+1; i++) {
        dp[i][0] = true;
    }
    for (int j = 1; j < sum+1; j++) {
        dp[0][j] = false;
    }
    
    for (int i = 1; i < n+1; i++) {
        for (int j = 1; j < sum+1; j++) {
            dp[i][j] = dp[i-1][j];
            if (j >= nums[i-1]) {
                dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
            }
        }
    }
   
    return dp[n][sum];
}
But can we optimize it? It seems that we cannot optimize it in time. But we can optimize in space. We currently use two dimensional array to solve it, but we can only use one dimensional array.

So the code becomes:

public boolean canPartition(int[] nums) {
    int sum = 0;
    
    for (int num : nums) {
        sum += num;
    }
    
    if ((sum & 1) == 1) {
        return false;
    }
    sum /= 2;
    
    int n = nums.length;
    boolean[] dp = new boolean[sum+1];
    Arrays.fill(dp, false);
    dp[0] = true;
    
    for (int num : nums) {
        for (int i = sum; i > 0; i--) {
            if (i >= num) {
                dp[i] = dp[i] || dp[i-num];
            }
        }
    }
    
    return dp[sum];
}
For Chinese user: http://love-oriented.com/pack/P01.html is good explanation.
*/
class 416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int count = 0, n = nums.length;
        if ( n == 0 || n == 1 ) return false;
        Arrays.sort(nums);
        int s = 0, e = n - 1, tmp;
        while ( s < e ) {
            tmp = nums[s];
            nums[s++] = nums[e];
            nums[e--] = tmp;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        for ( int i = 1; i < n; i++ ) dp[i] = nums[i] + dp[i-1];
        if ( dp[n-1] % 2 == 1 ) return false;
        int l = 0, h = n - 1, m;
        while ( l < h ) {
            m = ( l + h ) / 2;
            if ( dp[m] >= dp[n-1] / 2 ) {
                h = m;
            }
            else l = m + 1;
        }
        
        if ( dp[h] == dp[n-1] / 2 ) return true;
        int cur = dp[h] - nums[h], i = h + 1, j = h;
        boolean no;
        while ( cur != dp[n-1] / 2 ) {
            no = false;
            Search:
            while ( true ) {
                while ( cur < dp[n-1] / 2 ) {
                    if ( i < n ) {
                        cur += nums[i++];
                    }
                    else {
                        //no = true;
                        break Search;
                    }
                }
                if ( cur  == dp[n-1] / 2 ) return true;
                cur -= nums[i-1];
            }
            if ( j - 1 < 0 ) return false;
            cur = dp[--j];
            i = h + 1;
        }
        return false;
    }
}