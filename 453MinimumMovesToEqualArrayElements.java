class 453MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        if ( nums.length == 0 || nums.length == 1 ) return 0;
        Arrays.sort(nums);
        int sum = 0;
        int min = nums[0];
        for ( int i : nums )
            sum += i - min;
        return sum;
    }
}