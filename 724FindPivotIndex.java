class 724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0, left = 0, right = 0, n = nums.length;
        for ( int i : nums ) sum += i;
        for ( int i = 0; i < n; i++ ) {
            if ( left == sum - nums[i] - left ) return i;
            left += nums[i];
        }
        return -1;
    }
}