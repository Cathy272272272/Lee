/ ** Learn StringBuilder
  * much more efficient than String!!!
  * trim() is space efficient.
  * /

 class 557ReverseWordsInAStringIII{
    public String reverseWords(String s) {
        StringBuilder out = new StringBuilder();   
        int k;
        String words[] = s.split(" ");
        for ( int i = 0; i < words.length; i++ ){
            for ( int j = 0; j < words[i].length(); j++ )
                out.append(words[i].charAt(words[i].length() - 1 - j));
        out.append(" ");
        }
        return out.deleteCharAt(out.length() - 1).toString().trim();
    }
}
/*
 * public class Solution {
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }
}
 */