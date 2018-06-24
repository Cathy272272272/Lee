/*
 * class Solution {
    public int findLength(int[] A, int[] B) {
        if(A == null||B == null) return 0;
        int m = A.length;
        int n = B.length;
        int max = 0;
        //dp[i][j] is the length of longest common subarray ending with nums[i] and nums[j]
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0;i <= m;i++){
            for(int j = 0;j <= n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else{
                    if(A[i - 1] == B[j - 1]){
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        max = Math.max(max,dp[i][j]);
                    }
                }
            }
        }
        return max;
    }
}
*/
class 718MaximumLengthofRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        int max = 0, count, mark;
        int a = A.length, b = B.length;
        for ( int i = 0; i < a; i++ ) {
            count = 0;
            mark = i;
            for ( int j = 0; j < b; j++ ) {
                if ( i + 1 <= a ) {
                    if ( A[i++] == B[j] ) {
                        count++;
                    }
                    else {
                        i = mark;
                        if ( count > max ) max = count;
                        count = 0;
                        if (A[i] == B[j]) { 
                            count++;
                            i++;
                        }
                    }
                }
                else {
                    if ( count > max ) max = count;
                    break;
                }
            }
            if ( count > max ) max = count;
            i = mark;
        }
        for ( int i = 0; i < b; i++ ) {
            count = 0;
            mark = i;
            for ( int j = 0; j < a; j++ ) {
                if ( i + 1 <= b ) {
                    if ( B[i++] == A[j] ) {
                        count++;
                    }
                    else {
                        i = mark;
                        if ( count > max ) max = count;
                        count = 0;
                        if (B[i] == A[j]) { 
                            count++;
                            i++;
                        }
                    }
                }
                else {
                    if ( count > max ) max = count;
                    break;
                }
            }
            if ( count > max ) max = count;
            i = mark;
        }
        return max;
    }
}