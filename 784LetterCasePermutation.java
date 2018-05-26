/*
 * StringBuilder is a reference, dangerous to use,
 * when 
 * StringBuilder t = new StringBuilder();
 * StringBuilder t1 = t;
 * when altering t1, t will also change.
 * 
 * Only doing this (below), t will not change w.r.p. t1.
 * StringBuilder t = new StringBuilder();
 * StringBuilder t1 = new StringBuilder();
 * 
 */

/*
 * When I saw a problem, my first step is to draw a figure. See the figure below:
abc
abc Abc 0
abc aBc Abc ABc 1
abc abC aBc aBC Abc AbC ABc ABC 2

There we go! Is that a typical BFS/DFS problem? Yes, you are right!
Be careful to check whether a character is a digit or a letter(lower case or upper case).
BFS Solution:

class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;            
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();
                
                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));
                
                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }
        
        return new LinkedList<>(queue);
    }
}
DFS Solution:

class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        
        List<String> res = new LinkedList<>();
        helper(S, res, 0);
        return res;
    }
    
    public void helper(String s, List<String> res, int pos) {
        if (pos == s.length()) {
            res.add(s);
            return;
        }
        if (s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
            helper(s, res, pos + 1);
            return;
        }
        
        char[] chs = s.toCharArray();
        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(String.valueOf(chs), res, pos + 1);
        
        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(String.valueOf(chs), res, pos + 1);
    }
}
 */
 class 784LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
    List<String> result = new ArrayList<String>();
    List<String> a = new ArrayList<String>();
    StringBuilder temp1 = new StringBuilder();
    StringBuilder temp2 = new StringBuilder();
    char check, check1, check2;
    int length = 0;
    int i = 0;
    if ( S.length() == 0 ) {
        result.add("");
        return result;
    }
    if ( S.length() == 1 ) {
        if (S.compareTo("A") >= 0 && S.compareTo("z") <= 0 ){ 
            result.add(S.toLowerCase());
            result.add(S.toUpperCase());
        }
        else result.add(S);
        return result;
    }
    if ( S.length() <= 12 ){
        check = S.charAt(i);
        while ( !((check >= 'A' && check <= 'Z') || (check >= 'a' && check <= 'z') )) {
            if ( i + 1 == S.length())
                break;
            temp1.append(check);
            temp2.append(check);
            check = S.charAt(++i); 
        }
        String temp = temp1.toString();
        if (i + 1 == S.length() && (check > 'z' || check < 'A' ))  {result.add(S); return result;}
        if ( check >= 'a' && check <= 'z' ) {
            check1 = check;
            check2 = (char)(check -'a' + 'A');
        }
        else {
            check1 = (char)(check + 'a' - 'A');
            check2 = check;
        }
            a = letterCasePermutation(S.substring(i + 1));
        for ( int j = 0; j < a.size(); j++ ){
            result.add(temp1.append(check1).append(a.get(j)).toString());
            temp1 = new StringBuilder(temp);
        }
        for ( int j = 0 ; j < a.size(); j++ ){
            result.add(temp2.append(check2).append(a.get(j)).toString());
            temp2 = new StringBuilder(temp);
        }
    }
        return result;
    }
}