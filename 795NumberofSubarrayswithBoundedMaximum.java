/*
 * class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int j=0,count=0,res=0;
        
        for(int i=0;i<A.length;i++){
            if(A[i]>=L && A[i]<=R){
                res+=i-j+1;count=i-j+1;
            }
            else if(A[i]<L){
                res+=count;
            }
            else{
                j=i+1;
                count=0;
            }
        }
        return res;
    }
}
*/
class 795NumberofSubarrayswithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int n = A.length, mark = 0, sum = 0;
        if ( n < 1 || n > 50000 ) return 0;
        for ( int i = 0; i < n; i++ ) {
            if ( A[i] > R ) {
                sum += count(Arrays.copyOfRange(A, mark, i), L);
                mark = i + 1;
            }
        }
        return sum + count(Arrays.copyOfRange(A, mark, n), L);
    }
    public int count(int[] A, int L) {
        int n = A.length;
        if ( n == 0 ) return 0;
        int mark = -1, sum = 0;
        for ( int i = 0; i < n; i++ ) {
            if ( A[i] >= L ) {
                sum += (i - mark) * (n - i);
                mark = i;
            }
        }
        return sum;
    }
}