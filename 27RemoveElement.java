class 27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if ( n == 0 ) return 0;
        int mark = n - 1, tmp;
        for ( int i = n-1; i >= 0; i-- ) {
            if ( nums[i] == val ) {
                tmp = nums[i];
                nums[i] = nums[mark];
                nums[mark] = tmp;
                mark--;
            }
        }
        return mark + 1;
    }
}