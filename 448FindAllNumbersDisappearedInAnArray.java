class 448FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> out = new ArrayList<Integer>();
        int length = nums.length;
        for ( int i = 0; i < length; i++ )  {
            if ( nums[Math.abs(nums[i]) - 1] > 0 )
            nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1]; 
        }
        for ( int i = 0; i < length; i++ ) if ( nums[i] > 0 ) out.add(i + 1);
        return out;
    }
} 