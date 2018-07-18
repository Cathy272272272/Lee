class 376WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if ( nums.length <= 1 ) return nums.length;
        int sign = 0, prev = nums[0], len = 0, max = 0;
        for ( int i : nums ) {
            if ( sign == 0 && prev == i ) continue;
            if ( sign == 0 ) {
                if ( i > prev ) {
                    sign = 1;
                    len++;
                    prev = i;
                }
                if ( i < prev ) {
                    sign = -1;
                    len++;
                    prev = i;
                }
                continue;
            }
            if ( sign == 1 ) {
                if ( i < prev ) {
                    sign = -1;
                    prev = i;
                    len++;
                }
                if ( i > prev ) prev = i;
            }
            else {
                if ( i > prev ) {
                    sign = 1;
                    prev = i;
                    len++;
                }
                if ( i < prev ) prev = i;
            }
        }
        return len + 1;
    }
}