/*
 * // Shift non-zero values as far forward as possible
// Fill remaining space with zeros

public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) return;        

    int insertPos = 0;
    for (int num: nums) {
        if (num != 0) nums[insertPos++] = num;
    }        

    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }
}
*/
class 283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int numOfZero = 0;
        int index;
        for ( int i = nums.length - 1; i >= 0; i-- ){
            if ( nums[i] == 0 ){
                for ( int j = i + 1; j < nums.length; j++ ){
                    if ( nums[j] == 0 )
                        break;
                    else{
                        nums[j-1] = nums[j];
                        nums[j] = 0;
                    }
                }
            }
        }
    }
}