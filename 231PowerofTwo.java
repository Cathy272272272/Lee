/*Power of 2 means only one bit of n is '1', so use the trick n&(n-1)==0 to judge whether that is the case

class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n<=0) return false;
        return !(n&(n-1));
    }
};
*/
class 231PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if ( n <= 0 ) return false;
        while ( n > 1 ) {
            if ( n % 2 == 1 ) return false;
            n /= 2;
        }
        return true;
    }
}