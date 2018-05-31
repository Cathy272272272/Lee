class 169MajorityElement {
    public int majorityElement(int[] nums) {
        if ( nums.length == 1 ) return nums[0];
        int bar = nums.length/2;
        int count = 1;
        Arrays.sort(nums);
        for ( int i = 1; i < nums.length; i++ ) {
            if ( nums[i] == nums[i - 1] ) {
                count++;
                if ( count > bar ) 
                    return nums[i];
            }
            else {
                count = 1;
            }
        }
        return 0;
    }
}