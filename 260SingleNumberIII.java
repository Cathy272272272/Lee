/*
 * My method is too slow......
 * Learning XOR & diff &= -diff, diff &= ~(diff - 1)
 * Why diff &= ~(diff - 1)
First, this the original formula to get the last set bit. The diff &= -diff is just an abbreviation with the knowledge of ~(diff - 1) = - (diff - 1) - 1 = -diff.

If diff is set on the least significant bit, then this is trivially provable: the least significant bit is the last set bit. After the -1 operation, this least significant bit became 0, and is the only change to all bits of diff. Then we ~ the result, which means the least significant bit gets reverted to 1, while all the other bits are guaranteed to have been reverted. Thus the least significant bit is the only bit that is left unchanged and that could survive the & operation.
If diff is unset on the least significant bit: let's focus on the rightmost occurrence of 10 in diff. The 1 bit in this 10 is the last set bit of diff. After -1 operation, this 10 becomes 01. All the 0 bits to the right of this rightmost 10 are all change to 1 bits, and all the other whatever bits to the left of this rightmost 10 would be remain unchanged:
**..**10_00..00
after -1:
**..**01_11..11
Then we do ~ operation. The **..** part would all be reverted, and none of them would survive the upcoming & operation. 01 would become back 10, and would both survive the & operation, although the bit 1 is the only one we care about. All those 11..11 part gets reverted back to 00..00 after the ~ operation, and does not matter to the & operation. Thus the only thing surviving the & operation would be the rightmost 10, or the last set bit which is within it.

Incidentally, it does not really matter which bit we choose for the second pass to succeed, but since there is an elegant way to find the rightmost set bit, then let's use that.

public class Solution {
    public int[] singleNumber(int[] nums) {
        // Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;
        
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
If you were stuck by this problem, it's easy to find a solution in the discussion. However, usually, the solution lacks some explanations.

I'm sharing my understanding here:

The two numbers that appear only once must differ at some bit, this is how we can distinguish between them. Otherwise, they will be one of the duplicate numbers.

One important point is that by XORing all the numbers, we actually get the XOR of the two target numbers (because XORing two duplicate numbers always results in 0). Consider the XOR result of the two target numbers; if some bit of the XOR result is 1, it means that the two target numbers differ at that location.

Let¡¯s say the at the ith bit, the two desired numbers differ from each other. which means one number has bit i equaling: 0, the other number has bit i equaling 1.

Thus, all the numbers can be partitioned into two groups according to their bits at location i.
the first group consists of all numbers whose bits at i is 0.
the second group consists of all numbers whose bits at i is 1.

Notice that, if a duplicate number has bit i as 0, then, two copies of it will belong to the first group. Similarly, if a duplicate number has bit i as 1, then, two copies of it will belong to the second group.

by XoRing all numbers in the first group, we can get the first number.
by XoRing all numbers in the second group, we can get the second number.
*/
class 260SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        boolean a[] = new boolean[nums.length];
        int count = 0;
    for ( int i = 0; i < nums.length; i++ ){
        for ( int j = i + 1; j < nums.length; j++ ){
            if (nums[i] == nums[j]){
                a[j] = true;
                a[i] = true;
                count += 2;
            }
        }
    }
    int[] out = new int[nums.length - count];
    count = 0;
    for ( int i = 0; i < nums.length; i++ ){
        if ( !a[i] ){
            out[count] = nums[i];
            count++;
        }
    }
        return out;
    }
}