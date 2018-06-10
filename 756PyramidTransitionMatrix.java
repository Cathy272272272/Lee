// Don't use Map<T, StringBuilder>, map will put nothing with the type StringBuilder......
/* Similar answer, but mine is very slow?
 * class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0,2);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s.substring(2));
        }
        
        return helper(bottom, map);
    }
    
    private boolean helper(String bottom, Map<String, List<String>> map) {
        if(bottom.length() == 1) return true;
        for (int i = 0; i<bottom.length()-1; i++) {
            if (!map.containsKey(bottom.substring(i,i+2))) return false;
        }
        List<String> ls = new ArrayList<>();
        getList(bottom, 0, new StringBuilder(), ls, map);
        for (String s : ls) {
            if (helper(s, map)) return true;
        }
        return false;
    }
    
    private void getList(String bottom, int idx, StringBuilder sb, List<String> ls, Map<String, List<String>> map) {
        if (idx == bottom.length() - 1) {
            ls.add(sb.toString());
            return;
        }
        for (String s : map.get(bottom.substring(idx, idx+2))) {
            sb.append(s);
            getList(bottom, idx + 1, sb, ls, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
*/
class 756PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int n = bottom.length();
        int size = allowed.size();
        if ( n < 2 || n > 8 ) return false;
        if ( size < 0 || size > 200 ) return false;
        Map<Integer, String> cur = new HashMap<Integer, String>();
        for ( int i = 0; i < n; i++ ) {
            cur.put(i, bottom.substring(i,i+1));
        }
        return test(cur, n, allowed);
        
    }
    public boolean test(Map<Integer,String> cur, int n, List<String> allowed) {
        if ( n == 1 ) return true;
        Map<Integer, String> map = new HashMap<Integer, String>();
        StringBuilder l = new StringBuilder();
        StringBuilder r = new StringBuilder();
        StringBuilder build = new StringBuilder();
        int lsize;
        int rsize;
        for ( int i = 1; i < n; i++ ) {
            l.append(cur.get(i-1));
            r.append(cur.get(i));
            lsize = l.length();
            rsize = r.length();
            for ( String s : allowed ) {
                for ( int j = 0; j < lsize; j++ ) {
                    for ( int k = 0; k < rsize; k++ ) {
                        if ( s.substring(0,1).equals(l.substring(j,j+1).toString()) && s.substring(1,2).equals(r.substring(k,k+1).toString())) {
                                if ( !build.toString().contains(s.substring(2)))
                                    build.append(s.substring(2));
                            }
                    }
                }
            }
            if ( build.length() > 0) {
                map.put(i-1,build.toString());
                build.delete(0,build.length());
            }
            if ( !map.containsKey(i-1)) return false;
            l.delete(0,l.length());
            r.delete(0,r.length());
        }
        return test(map, n-1, allowed);
    }
}
