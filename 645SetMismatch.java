class 645SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int xor0 = 0, xor1 = 0;
        int n = nums.length;
        int[] help = new int[n+1];
        int[] ans = new int[2];
        for ( int i = 0; i < n; i++ ) {
            xor0 ^= (i+1);
            xor1 ^= nums[i];
            if ( help[nums[i]] == 1 ) ans[0] = nums[i];
            help[nums[i]]++;
        }
        ans[1] = xor0 ^ xor1 ^ ans[0];
        return ans;
    }
}