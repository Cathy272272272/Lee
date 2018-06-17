Just 4 steps:

Split S into several special strings (as many as possible).
Special string starts with 1 and ends with 0. Recursion on the middle part.
Sort all special strings in lexicographically largest order.
Join and output all strings.
Updated:

The middle part of a special string may not be another special string. But in my recursion it is.
For example, 1M0 is a splitted special string. M is its middle part and it must be another special string.

Because:

The number of 0's is equal to the number of 1's in M
If there is a prefix P of Mwhich has one less 1's than 0's, 1P will make up a special string. 1P will be found as special string before 1M0 in my solution.
It means that every prefix of M has at least as many 1's as 0's.
Based on 2 points above, M is a special string.
    
    public String makeLargestSpecial(String S) {
        int count = 0, i = 0;
        List<String> res = new ArrayList<String>();
        for (int j = 0; j < S.length(); ++j) {
          if (S.charAt(j) == '1') count++;
          else count--;
          if (count == 0) {
            res.add('1' + makeLargestSpecial(S.substring(i + 1, j)) + '0');
            i = j + 1;
          }
        }
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }

/* Mine slow slow solution, but slightly faster than the second one......
 * class Solution {
    public String makeLargestSpecial(String S) {
        return help(S);
    }
    public String help(String S) {
        int n = S.length();
        if ( n == 0 ) return "";
        StringBuilder tmp = new StringBuilder();
        int mark3 = 0, mark2 = 0, mark1 = 0;
        if ( S.equals("10")) return S;
        for ( int i = n; i > 0; i-- ) {
            int j = i-1;
            while ( j >= 0 ) {
                String s = S.substring(j, i);
                if ( check(s) ) {
                        int l = j - 1;
                        while ( l >= 0 ) {
                            String t = S.substring(l, j);
                            if ( check(t)) {
                                if ( s.compareTo(t) > 0 && !s.startsWith(t)) {
                                    mark1 = l;
                                    mark2 = j;
                                    mark3 = i; 
                                    StringBuilder t1 = new StringBuilder();
                                    StringBuilder t2 = new StringBuilder();
                                    t1.append(S.substring(0,mark1)).append(S.substring(mark2,mark3));
                                    t2.append(S.substring(mark1, mark2)).append(S.substring(mark3));
                                   return makeLargestSpecial(t1.append(t2).toString());
                                }
                            }
                            l--;
                        }
                    }
                j--;
            }
        }
            return S;
    }
    public boolean check(String S) {
        int count = 0;
        for ( char i : S.toCharArray() ) {
            if ( i == '1' ) count++;
            else count--;
            if ( count < 0 ) return false;
        }
        if ( count == 0 ) return true;
        return false;
    }
}
*/
class 761SpecialBinaryString {
    public String makeLargestSpecial(String S) {
        int n = S.length();
        if ( n == 0 ) return "";
        StringBuilder tmp = new StringBuilder();
        int mark = 0, mark3 = 0, mark2 = -1, mark1 = 0;
        boolean c = false;
        String tmp1 = "", tmp2 = "";
        
        for ( int i = 0; i < n; i++ ) tmp.append("1");
        String help = tmp.toString();
        if ( S.equals("10")) return S;
        boolean reverse = false;
        for ( int i = n; i > 0; i-- ) {
            int j = i-1;
            while ( j >= 0 ) {
                String s = S.substring(j, i);
                if ( check(s) ) {
                        int l = j - 1;
                        while ( l >= 0 ) {
                            String t = S.substring(l, j);
                            if ( check(t)) {
                                if ( s.compareTo(t) > 0 && !s.startsWith(t)) {
                                    if ( t.compareTo(help) < 0 ) {
                                        mark1 = l;
                                        mark2 = j;
                                        mark3 = i;
                                        help = t;
                                        reverse = true;
                                    }   
                                }
                            }
                            l--;
                        }
                }
                j--;
            }
        }
        if ( help.equals(tmp.toString())) return S;
        StringBuilder t1 = new StringBuilder();
        StringBuilder t2 = new StringBuilder();
        t1.append(S.substring(0,mark1)).append(S.substring(mark2,mark3));
        t2.append(S.substring(mark1, mark2)).append(S.substring(mark3));
        tmp.delete(0, n);
        return makeLargestSpecial(t1.append(t2).toString());
    }
    public boolean check(String S) {
        int count = 0;
        for ( char i : S.toCharArray() ) {
            if ( i == '1' ) count++;
            else count--;
            if ( count < 0 ) return false;
        }
        if ( count == 0 ) return true;
        return false;
    }
}