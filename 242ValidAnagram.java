/* Mine is too slow.....Maybe I use toString() too much...
 * public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
 * */
class 242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int sL = s.length();
        int tL = t.length();
        if ( tL != sL ) return false;
        StringBuilder tmp = new StringBuilder(s);
        for ( int i = 0; i < tL; i++ ) {
            if ( !tmp.toString().contains(String.valueOf(t.substring(i, i+1))))
                return false;
            tmp.deleteCharAt(tmp.indexOf(t.substring(i, i+1)));
        }
        return true;
    }
}