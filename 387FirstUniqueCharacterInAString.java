//Mine is too slow......
/*
 * public class Solution {
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
*/
class 387FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if ( s.length() == 0 ) return -1;
        int n = s.length();
        if ( !s.substring(1).contains(s.substring(0,1))) return 0;
        for ( int i = 1; i < n - 1; i++ ) {
            if ( ! (s.substring(i + 1).contains(s.substring(i,i+1)) ||  s.substring(0, i).contains(s.substring(i, i+1)))) 
                return i;
        }
        if ( !s.substring(0, n - 1).contains(s.substring(n - 1))) return n - 1;
        return -1;
    }
}