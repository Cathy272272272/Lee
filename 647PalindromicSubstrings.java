/*
 * public class Solution {
    int count = 0;
    
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }
        
        return count;
    }
    
    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
}
*/
class 647PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for ( int i = 0; i < s.length(); i++ )
            for ( int j = i + 1; j <= s.length(); j++ )
                if (palin(s.substring(i, j)))
                    count++;
        return count;
    }
    public boolean palin(String s){
        for ( int i = 0; i < s.length() / 2; i++ )
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        return true;
    }
}