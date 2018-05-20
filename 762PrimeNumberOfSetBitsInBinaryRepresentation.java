/*
 * class Solution {
    public int countPrimeSetBits(int l, int r) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19 /*, 23, 29 */ ));
        int cnt = 0;
        for (int i = l; i <= r; i++) {
            int bits = 0;
            for (int n = i; n > 0; n >>= 1)
                bits += n & 1;
            cnt += primes.contains(bits) ? 1 : 0;
        }
        return cnt;        
    }
}
*/
class 762PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        int count1 = 0;
        int count2 = 0;
        int temp = 0;
        if ( L >= 1 && L <= 1000000 && R >= 1 && R >= 1 && R <= 1000000 && R - L <= 10000 && L <= R ){
            for ( int i = L; i < R + 1; i++ ){
                count1 = 0;
                temp = i;
                while ( temp != 0 ){
                    if ( temp%2 == 1 )
                        count1++;
                    temp /= 2;
                }
                if ( count1 == 1 ){
                    count2++;
                    continue;
                }
                for ( int j = 2; j <= Math.sqrt(count1); j++ )
                    if ( (count1 / ( j + 0.0 )) == count1 / j ){ //divisible
                        count2++;
                        break;
                }
            }
        }
        return R - L + 1 - count2;
    }
}