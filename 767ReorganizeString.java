/*
 * class Solution {
    public String reorganizeString(String S) {
        // Create map of each char to its count
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            // Impossible to form a solution
            if (count > (S.length() + 1) / 2) return "";
            map.put(c, count);
        }
        // Greedy: fetch char of max count as next char in the result.
        // Use PriorityQueue to store pairs of (char, count) and sort by count DESC.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) {
            pq.add(new int[] {c, map.get(c)});
        }
        // Build the result.
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }
}
*/
class 767ReorganizeString {
    public String reorganizeString(String S) {
        int[] a = new int[26];
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        int n = S.length();
        if ( n == 0 ) return "";
        int max = 0;
        char tmp = S.charAt(0);
        for ( char i : S.toCharArray() ) {
            a[i-'a']++;
        }
        for ( int i = 0; i < 26; i++ ) {
            if(a[i] != 0 ) {
                map.put(a[i], map.getOrDefault(a[i], "") + String.valueOf((char)('a' + i)));
            }
        }
        Integer key = map.lastKey();
        if ( n -2 * key + 1 < 0 ) return "";
        StringBuilder ans = new StringBuilder();
        while ( map.size() != 0 ) {
            TreeMap<Integer, String> copy = new TreeMap<Integer, String>(map);
            key = copy.lastKey();
            for ( int i = 0; i < 2; i++ ) {
                int len = copy.get(key).length();
                ans.append(map.get(key).charAt(0));
                copy.put(key - 1, copy.getOrDefault(key - 1, "") + copy.get(key).charAt(0));
                if ( len > 1 ) {
                    copy.put(key, copy.get(key).substring(1));
                }
                else copy.remove(key);
                key = map.lowerKey(key);
                if ( key == null ) break;
            }
            map = copy;
            if ( map.firstKey() == 0 ) map.remove(map.firstKey());
        }
        return ans.toString();
    }
}