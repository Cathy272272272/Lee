class 643MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        if ( n < k ) return 0.0;
        double max = 0;
        for ( int i = 0; i < k; i++ ) max += nums[i];
        if ( n == k ) return max / k;
        double help = max;
        for ( int i = k; i < n; i++ ) {
            help += nums[i] - nums[i-k];
            max = Math.max(max, help);
        }
        return max / k;
    }
}