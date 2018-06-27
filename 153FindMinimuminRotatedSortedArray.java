class 153FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length;
        if ( n == 0 ) return 0;
        if ( n == 1 ) return nums[0];
        int lo = 0, hi = n-1, prelo = lo;
        if ( nums[lo] < nums[hi] ) return nums[lo];
        while ( lo < hi ) {
            if ( nums[lo] > nums[hi] ) {
                prelo = lo;
                lo = (lo + hi + 1) / 2;
            }
            else {
                hi = lo;
                lo = prelo + 1;
            }
        }
        return nums[lo];
    }
}