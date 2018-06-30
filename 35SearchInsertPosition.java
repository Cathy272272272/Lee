class 35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if ( n == 0 ) return 0;
        if ( n == 1 ) return target <= nums[0] ? 0 : 1;
        int l = 0, h = n - 1, m;
        while ( l < h ) {
            m = ( l + h ) / 2;
            if ( nums[m] < target ) l = m + 1;
            else h = m;
        } 
        if ( h == n - 1 && nums[n-1] < target ) return n;
        return h;
    }
}