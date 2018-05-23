/*Though my logic is simple, but my running time is slow......
 * public int numberOfArithmeticSlices(int[] A) {
    int curr = 0, sum = 0;
    for (int i=2; i<A.length; i++)
        if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
            curr += 1;
            sum += curr;
        } else {
            curr = 0;
        }
    return sum;
}
*/
class 413ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        if ( A.length < 3 )
            return 0;
        else{
            count += numberOfArithmeticSlices(Arrays.copyOfRange(A, 1, A.length));
            for ( int i = 2; i < A.length; i++ ){
                if ( A[1] - A[0] == A[i] - A[i - 1] )
                count++;
                else break;
            }
        }
        return count;
    }
}