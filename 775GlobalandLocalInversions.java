/*
 * All local inversions are global inversions.
If the number of global inversions is equal to the number of local inversions,
it means that all global inversions in permutations are local inversions.
It also means that we can not find A[i] > A[j] with i+2<=j.
In other words, max(A[i]) < A[i+2]

In this first solution, I traverse A and keep the current biggest number cmax.
Then I check the condition cmax < A[i+2]

Here come this solutions:

C++:

bool isIdealPermutation(vector<int>& A) {
        int cmax = 0, n = A.size();
        for (int i = 0; i < n - 2; ++i) {
            cmax = max(cmax, A[i]);
            if (cmax > A[i + 2]) return false;
        }
        return true;
    }
Java:

public boolean isIdealPermutation(int[] A) {
        int cmax = 0;
        for (int i = 0; i < A.size() - 2; ++i) {
            cmax = Math.max(cmax, A[i]);
            if (cmax > A[i + 2]) return false;
        }
        return true;
    }
    */
class 775GlobalandLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        if ( n == 1 ) return true;
        int[] dp = new int[n];
        for ( int i = n - 1; i > 0; i-- ) {
            if ( A[i-1] > A[i] ) {
                if ( !help(A, i, dp) ) return false;
                if ( !helpp(A, i-1, dp)) return false;
            }
        }
        return true;
    }
    public boolean helpp(int[] A, int idx, int[] dp) {
        int n = A.length;
        if ( idx >= n - 2 ) return true;
        if ( dp[idx] != 0 ) return dp[idx] == 1;
        for ( int i = idx + 2; i < n - 1; i++ ) {
            if ( A[i] < A[idx] ) {
                dp[idx] = -1;
                return false;
            }
        }
        if ( A[n-1] < A[idx] ) {
            dp[idx] = -1;
            return false;
        }
        dp[idx] = 1;
        return true;
    }
    public boolean help(int[] A, int idx, int[] dp) {
        int n = A.length;
        if ( idx < 2 ) return true;
        if ( dp[idx] != 0 ) return dp[idx] == 1;
        for ( int i = idx - 2; i > 0; i-- ) {
            if ( A[i] > A[idx] ) {
                dp[idx] = -1;
                return false;
            }
        }
        if ( A[0] > A[idx] ) {
            dp[idx] = -1;
            return false;
        }
        dp[idx] = 1;
        return true;
    }
}