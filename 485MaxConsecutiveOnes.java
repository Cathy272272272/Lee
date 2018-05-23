/*
 *     public int findMaxConsecutiveOnes(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max; 
    }
    */
class 485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int i, j;
        if ( nums.length <= 10000 && nums.length > 0 )
            for ( i = 0; i < nums.length; i++ )
                if ( nums[i] == 1 ){
                    for ( j = i; j < nums.length; j++ )
                        if ( nums[j] != 1 )
                            break;
                    if ( j - i > max )
                        max = j - i;
                }
        return max;
    }
}