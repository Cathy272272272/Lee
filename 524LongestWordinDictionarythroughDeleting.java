/*Can use compareTo() to replace sort......
 * public String findLongestWord(String s, List<String> d) {
    String longest = "";
    for (String dictWord : d) {
        int i = 0;
        for (char c : s.toCharArray()) 
            if (i < dictWord.length() && c == dictWord.charAt(i)) i++;

        if (i == dictWord.length() && dictWord.length() >= longest.length()) 
            if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
                longest = dictWord;
    }
    return longest;
}
*/
class 524LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        if ( d.size() == 0 ) return "";
        if ( d.size() > 1000 ) return "";
        List<String> list = new ArrayList<String>();
        int max = 1, mark = 0;
        for ( String i : d ) {
            int t = max(s, i);
            if ( t > max ) {
                max = t;
                list.clear();
                list.add(i);
            }
            else if ( t == max ) list.add(i);
        }
        if ( list.size() == 0 ) return "";
        if (list.size() == 1 ) return list.get(0);
        Collections.sort(list);
        return list.get(0);
    }
    public int max(String s, String i) {
        int ns = s.length();
        int is = i.length();
        int count = 0, max = 0;
        if ( is > ns ) return 0;
        Search:
        for ( int j = 0; j < is; j++ ) {
            if ( count == ns ) return 0;
            while ( i.charAt(j) != s.charAt(count) ) {
                if ( count == ns - 1 ) return 0;
                count++;
            }
            count++;
            max++;
        }
        return max;
    }
}