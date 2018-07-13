class 80RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if ( n <= 2 ) return 2;
        int count = 1, cur = nums[0], len = 1;
        for ( int i = 1; i < n; i++ ) {
            if ( nums[i] == cur ) count++;
            else {
                cur = nums[i];
                count = 1;
            }
            if ( count <= 2 ) {
                nums[len] = cur;
                len++;
            }
        }
        return len;
    }
}