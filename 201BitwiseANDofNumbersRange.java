/*
 * The hardest part of this problem is to find the regular pattern.
For example, for number 26 to 30
Their binary form are:
11010
11011
11100　　
11101　　
11110

Because we are trying to find bitwise AND, so if any bit there are at least one 0 and one 1, it always 0. In this case, it is 11000.
So we are go to cut all these bit that they are different. In this case we cut the right 3 bit.

I think after understand this, the code is trivial:

    public int rangeBitwiseAnd(int m, int n) {
      int i = 0; // i means we have how many bits are 0 on the right
      while(m != n){
        m >>= 1;
        n >>= 1;
        i++;  
      }  
      return m << i;  
    }
    */
class 201BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        if ( m == n ) return m;
        if ( m == 0 ) return 0;
        int mm = m, nn = n;
        while ( true ) {
            if ( (mm & 2147483647) == 0 && (nn & 2147483647) == 0 ) break;
            if ( (mm & 2147483647) == 0 || (nn & 2147483647) == 0 ) return 0;
            mm = mm >> 1;
            nn = nn >> 1;
        }
        long ans = (long)m;
        for ( long i = m + 1; i <= n; i++ ) {
            ans &= i;
            System.out.println(ans);
        }
        return (int)ans;
    }
}