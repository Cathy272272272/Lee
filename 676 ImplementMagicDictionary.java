class MagicDictionary {
    List<String> dic;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        List<String> dic = new ArrayList<String>();  
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        List<String> d = new ArrayList<String>();  
        for ( String i : dict ) {
            d.add(i);
        }
        
        /*for ( int i = 0; i < dict.length; i++ ) {
            System.out.println(dict[i]);
            d.add(dict[i]);
        }*/
        dic = d;
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        int count;
        for ( String i : dic ) {
            if ( i.length() == word.length() ) {
                count = 0;
                for ( int j = 0; j < i.length(); j++ ) {
                    if ( count == 2 )
                        break;
                    if ( word.charAt(j) != i.charAt(j) )
                        count++;
                }
                if ( count == 1 )
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */