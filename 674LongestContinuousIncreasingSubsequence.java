class 674LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int max = 1, n = nums.length, tmp = 1;
        if ( n == 0 ) return 0;
        for ( int i = 1; i < n; i++ ) {
            if ( nums[i] > nums[i-1] ) {
                tmp++;
            }
            else {
                if ( tmp > max ) max = tmp;
                tmp = 1;
            }
        }
        return Math.max(tmp, max);
    }
}