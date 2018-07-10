class 833FindAndReplaceinString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int n = indexes.length;
        TreeMap<Integer, List<String>> map = new TreeMap<Integer, List<String>>();
        List<String> tmp;
        for ( int i = 0; i < n; i++ ) {
            tmp = new ArrayList<String>();
            tmp.add(sources[i]);
            tmp.add(targets[i]);
            map.put(indexes[i], tmp);
        }
        StringBuilder ans = new StringBuilder();
        int cur = 0;
        for ( int i : map.keySet() ) {
            ans.append(S.substring(cur, i));
            tmp = map.get(i);
            if (S.substring(i).startsWith(tmp.get(0))) {
                cur = i + tmp.get(0).length();
                ans.append(tmp.get(1));
            }
            else cur = i;
        }
        ans.append(S.substring(cur));
        return ans.toString();
    }
}