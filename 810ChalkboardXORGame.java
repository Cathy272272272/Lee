class 810ChalkboardXORGame {
    public boolean xorGame(int[] nums) {
        int xor = 0, count = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for ( int i : nums ) xor ^= i;
        if ( xor == 0 || nums.length % 2 == 0 ) return true;
        /*for ( int i = 1; i < n; i++ ) {
            if ( (nums[i] ^ nums[i-1]) == 0 ) {
                count += 2;
                i++;
            }
        }
        if ( (nums.length - count) % 2 == 1 ) return false;*/
        //This is because nums.length%2 == 0 iff nums.length - count) % 2 == 0, since count is even.
        return false;
    }
}