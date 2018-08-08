/*
 * public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right) {
            int cur = left * left + right * right;
            if (cur < c) {
                left++;
            } else if (cur > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
*/
class 633SumofSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        while ( i <= Math.sqrt(c/2) ) {
            int tmp = c - i * i;
            if ( Math.pow((int)Math.sqrt(tmp), 2) == tmp ) return true;
            i++;
        }
        return false;
    }
}