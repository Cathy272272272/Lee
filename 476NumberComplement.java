class 476NumberComplement{
    public int findComplement(int num) {
        int out = 0;
        int count = 0;
        String s = "";
        while ( num > 0 ){
            if ( num % 2 == 1 )
                s += "1"; // caution: s is in reverse order to the binary expression
            else
                s += "0";
            num /= 2;
        }
        for ( int i = 0; i < s.length(); i++ ){
            if ( s.charAt(i) == '0' ) // complement is "1"
                out += Math.pow(2, i);
        }
        return out;
    }
}
/*
 * I post solution first and then give out explanation. Please think why does it work before read my explanation.

public class Solution {
    public int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
According to the problem, the result is

The flipped version of the original input but
Only flip N bits within the range from LEFTMOST bit of 1 to RIGHTMOST.
For example input = 5 (the binary representation is 101), the LEFTMOST bit of 1 is the third one from RIGHTMOST (100, N = 3). Then we need to flip 3 bits from RIGHTMOST and the answer is 010
To achieve above algorithm, we need to do 3 steps:

Create a bit mask which has N bits of 1 from RIGHTMOST. In above example, the mask is 111. And we can use the decent Java built-in function Integer.highestOneBit to get the LEFTMOST bit of 1, left shift one, and then minus one. Please remember this wonderful trick to create bit masks with N ones at RIGHTMOST, you will be able to use it later.
Negate the whole input number.
Bit AND numbers in step 1 and 2.
Three line solution if you think one line solution is too confusing:

public class Solution {
    public int findComplement(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        num = ~num;
        return num & mask;
    }
}
UPDATE
As several people pointed out, we don't need to left shift 1. That's true because the highest 1 bit will always become 0 in the Complement result. So we don't need to take care of that bit.

public class Solution {
    public int findComplement(int num) {
        return ~num & (Integer.highestOneBit(num) - 1);
    }
}
 */