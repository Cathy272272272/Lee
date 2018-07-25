class 213HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if ( n == 0 ) return 0;
        if ( n == 1 ) return nums[0];
        if ( n == 2 ) return Math.max(nums[0], nums[1]);
        if ( n == 3 ) return Math.max(nums[1], Math.max(nums[0], nums[2]));
        int[] rob = new int[n-1];
        int[] robb = new int[n-1];
        for ( int i = 0; i < n; i++ ) {
            if ( i == 0 ) {
                rob[i] = nums[i];
            }

            else if ( i == n - 1 ) {
                robb[i-1] = Math.max(robb[i-2], nums[i] + robb[i-3]);
            }
            else if ( i == 1 ) {
                rob[i] = Math.max(nums[i], nums[0]);
                robb[i-1] = nums[i];
            }
            else if ( i == 2 ) {
                rob[i] = Math.max(rob[i-1], nums[i] + rob[i-2]);
                robb[i-1] = Math.max(nums[1], nums[2]);
            }
            else {
                rob[i] = Math.max(rob[i-1], nums[i] + rob[i-2]);                
                robb[i-1] = Math.max(robb[i-2], nums[i] + robb[i-3]);                
            }
        }
        return Math.max(robb[n-2], rob[n-2]);
    }
}