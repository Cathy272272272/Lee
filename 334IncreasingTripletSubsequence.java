/*
 *    public boolean increasingTriplet(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }
    */
class 334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if ( n < 3 ) return false;
        int[] tmp = new int[n];
        tmp[0] = nums[0];
        int j = 0;
        int count = 0;
        for ( int i = 1; i < n; i++ ) {
            if ( nums[i] > tmp[j] ) {
                count++;
                j++;
                tmp[j] = nums[i];
            }
            if ( nums[i] < tmp[j] ) {
                if ( j == 0 ) tmp[j] = nums[i];
                else {
                    if ( increasingTriplet(Arrays.copyOfRange(nums, i, n)) ) return true;
                    if ( nums[i] > tmp[j-1] ) tmp[j] = nums[i];
                }
            }
            if ( count == 2 ) return true;
        }
        return false;
    }
}