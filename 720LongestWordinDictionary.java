class 720LongestWordinDictionary {
    public String longestWord(String[] words) {
        String res = "";
        TreeMap<Integer, List<String>> map = new TreeMap<Integer, List<String>>();
        List<String> list = new ArrayList<String>();
        for ( String i : words ) {
            list = map.getOrDefault(i.length(), new ArrayList<String>());
            list.add(i);
            map.put(i.length(), list);
        }
        int count;
        for ( int k = map.lastKey(); k > 0; k-- ){
            if ( !map.containsKey(k)) continue;
            list = map.get(k);
            Collections.sort(list);
            for ( String i : list ) {
                count = k;
                //tmp = i;
                while ( count > 1 ) {
                    if ( !map.containsKey(count - 1) ) break;
                    if ( map.get(count - 1).contains(i.substring(0, count - 1))) count--;
                    else break;
                }
                if ( count == 1 ) return i;
            }
        }
        return res;
    }
}