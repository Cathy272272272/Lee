/*
 * public String replaceWords(List<String> dict, String sentence) {
        String[] tokens = sentence.split(" ");
        TrieNode trie = buildTrie(dict);
        return replaceWords(tokens, trie);
    }

    private String replaceWords(String[] tokens, TrieNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String token : tokens) {
            stringBuilder.append(getShortestReplacement(token, root));
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }

    private String getShortestReplacement(String token, final TrieNode root) {
        TrieNode temp = root;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : token.toCharArray()) {
            stringBuilder.append(c);
            if (temp.children[c - 'a'] != null) {
                if (temp.children[c - 'a'].isWord) {
                    return stringBuilder.toString();
                }
                temp = temp.children[c - 'a'];
            } else {
                return token;
            }
        }
        return token;
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode(' ');
        for (String word : dict) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TrieNode(c);
                }
                temp = temp.children[c - 'a'];
            }
            temp.isWord = true;
        }
        return root;
    }

    public class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
    */
class 648ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        String[] s = sentence.split("\\s+");
        Collections.sort(dict, new Comparator<String>(){
            public int compare(String o1, String o2) {   
                if (o1.length() > o2.length()) {  
                    return 1;  
                }  
                if ( o1.length() < o2.length()) {  
                    return -1;  
                }  
                return 0;  
            }  
        });
        StringBuilder res = new StringBuilder();
        for ( String i : s ) {
            for ( String j : dict ) {
                if ( i.contains(j) && i.substring(0, j.length()).equals(j) ) {
                    i = j;
                    break;
                }
            }
            res.append(i).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}