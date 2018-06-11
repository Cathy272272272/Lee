/*Clever xor
 * The basic idea is to use XOR operation. We all know that a^b^b =a, which means two xor operations with the same number will eliminate the number and reveal the original number.
In this solution, I apply XOR operation to both the index and value of the array. In a complete array with no missing numbers, the index and value should be perfectly corresponding( nums[index] = index), so in a missing array, what left finally is the missing number.

public int missingNumber(int[] nums) {

    int xor = 0, i = 0;
 for (i = 0; i < nums.length; i++) {
  xor = xor ^ i ^ nums[i];
 }

 return xor ^ i;
}
*/
class 268MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] help = new int[n+1];
        for ( int i = 0; i < n; i++ ) 
            help[nums[i]] = -1;
        for ( int i = 0; i < n + 1; i++ ) 
            if ( help[i] == 0 )
                return i;
        return 0;
    }
}