/*
 * public static List<List<String>> groupAnagrams(String[] strs) { 
   int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//×î¶à10609¸öz
    
            List<List<String>> res = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (String s : strs) {
                int key = 1;
                for (char c : s.toCharArray()) {
                    key *= prime[c - 'a'];
                }
                List<String> t;
                if (map.containsKey(key)) {
                    t = res.get(map.get(key));
                } else {
                    t = new ArrayList<>();
                    res.add(t);
                    map.put(key, res.size() - 1);
                }
                t.add(s);
            }
            return res;
    }
    */
class 49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        List<String> tmp;
        Map<List<Integer>, List<String>> map = new HashMap<List<Integer>, List<String>>();
        int tmp0 = 0, tmp1 = 1;
        List<Integer> help;
        for ( String i : strs ) {
            tmp0 = 0;
            tmp1 = 1;
            for ( char j : i.toCharArray() ) {
                tmp0 += j;
                tmp1 *= j;
            }
            help = new ArrayList<Integer>();
            help.add(tmp0);
            help.add(tmp1);
            tmp = map.getOrDefault(help, new ArrayList<String>());
            tmp.add(i);
            map.put(help, tmp);
        }
        for ( List<String> i : map.values() ) list.add(i);
        return list;
    }
}