/* This one is much faster......
 * dp[i][j]: the longest palindromic subsequence's length of substring(i, j), here i, j represent left, right indexes in the string
State transition:
dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
Initialization: dp[i][i] = 1

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
*/
class 516LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        return help(s, new Integer[s.length()][s.length()], 0, s.length() - 1);
    }
    public int help(String s, Integer[][] dp, int start, int end) {
        if ( dp[start][end] != null ) return dp[start][end];
        if ( start > end ) return 0;
        if ( start == end ) return 1;
        char st = s.charAt(start), en = s.charAt(end);
        if ( st == en ) //if ( dp[start+1][end-1] == 0 )
        {
            dp[start+1][end-1] = help(s, dp, start+1, end-1);
            dp[start][end] = dp[start+1][end-1] + 2;
            return dp[start][end];
        }
        //if (dp[start][end-1] == 0 ) 
            dp[start][end-1] = help(s, dp, start, end-1);
        //if (dp[start + 1][end] == 0 ) 
            dp[start + 1][end] = help(s, dp, start+1, end);
        //if ( st == en ) dp[start][end] = Math.max(dp[start+1][end-1] + 2, Math.max(dp[start+1][end], dp[start][end-1]));
        //else 
        dp[start][end] = Math.max(dp[start+1][end], dp[start][end-1]);
        return dp[start][end];
    }
}