/* 2. Insert all reversed words to the trie.
For example, for word "time", we insert 'e', 'm', 'i', 't' successively.
 * TrieNode
 * class TrieNode {
    HashMap<Character, TrieNode> next = new HashMap<>();
    int depth;
}
class Solution {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        List<TrieNode> leaves = new  ArrayList<TrieNode>();
        for (String w : new HashSet<>(Arrays.asList(words))) {
            TrieNode cur = root;
            for (int i = w.length() - 1; i >= 0; --i) {
                char j = w.charAt(i);
                if (!cur.next.containsKey(j)) cur.next.put(j, new TrieNode());
                cur = cur.next.get(j);
            }
            cur.depth = w.length() + 1;
            leaves.add(cur);
        }
        int res = 0;
        for (TrieNode leaf : leaves) if (leaf.next.isEmpty()) res += leaf.depth;
        return res;
    }
}
*/
/* Easy to understand and fast......
 * class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> s = new HashSet<>(Arrays.asList(words));
        for (String w : words)
            for (int i = 1; i < w.length(); ++i)
                s.remove(w.substring(i));
        int res = 0;
        for (String w : s) res += w.length() + 1;
        return res;
    }
}
*/
class 820ShortEncodingofWords {
    public int minimumLengthEncoding(String[] words) {
        int n = words.length;
        if ( n == 0 ) return 0;
        Arrays.sort(words, (x, y) -> {
            StringBuilder xx = new StringBuilder(x);
            StringBuilder yy = new StringBuilder(y);    
            return xx.reverse().toString().compareTo(yy.reverse().toString());
        });
        int count = 0, sum = 0;
        for ( int i = 1; i < n; i++ ) {
            if ( words[i].endsWith(words[i-1]) ) continue;
            else {
                count++;
                sum += words[i-1].length();
            }
        }
        return sum + count + 1 + words[n-1].length();
    }
}