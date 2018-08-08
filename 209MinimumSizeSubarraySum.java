class 209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if ( n == 0 ) return 0;
        int sum = 0, idx1 = 0, idx2 = 0, min = Integer.MAX_VALUE;
        while ( idx2 < n && idx1 < n ) {
            sum += nums[idx2++];
            if ( sum >= s ) {
                while ( idx1 < idx2 ) {
                    if ( sum < s ) break;
                    sum -= nums[idx1++];
                }
                min = Math.min(min, idx2 - idx1 + 1);
                if ( min == 1 ) return 1;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}