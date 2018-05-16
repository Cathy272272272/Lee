class 561ArrayPartitionI{
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        if ( nums.length >= 2 && nums.length <= 20000 ){
            Arrays.sort(nums);
            for ( int i = 0; i < nums.length; i = i + 2 ){
                sum += nums[i];
            }
        }
        return sum;
    }
}