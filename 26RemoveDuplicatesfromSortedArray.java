class 26RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if ( n == 0 || n == 1 ) return n;
        int mark = 1, tmp = nums[0];
        for ( int i = 1; i < n; i++ ) {
            if ( nums[i] != tmp ) {
                tmp = nums[i];
                nums[mark] = tmp;
                mark++;
            }
        }
        return mark;
    }
}