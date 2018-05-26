/*
 * The logic is very similar to NO.347 and here we just use a map a count and according to the frequency to put it into the right bucket. Then we go through the bucket to get the most frequently character and append that to the final stringbuilder.

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        List<Character> [] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >=0; pos--) {
            if (bucket[pos] != null) {
                for (char num : bucket[pos]) {
                    for (int i = 0; i < map.get(num); i++) {
                        sb.append(num);
                    }
                }
            }
        }
        return sb.toString();
    }
}

And we have normal way using PriorityQueue as follows:

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                    return b.getValue() - a.getValue();
                }
            }
        );
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}
*/
class 451SortCharactersByFrequency {
    public String frequencySort(String s) {
        if ( s.length() == 0 ) return "";
        List<Character> result = new ArrayList<Character>();
        for ( int i = 0; i < s.length(); i++ ){
            result.add(s.charAt(i));
        }
        List<Integer> order = new ArrayList<Integer>();
        Map<Integer, Character> map = new HashMap<>();
        Map<Integer,Map<Integer,Character>> largeMap = new HashMap<>();
        Collections.sort(result);
        int count = 1;
        int max = 0;
        int min = 1;
        Character a = result.get(0);
        for ( int i = 1; i < s.length(); i++ ){
            if ( a == result.get(i) )
                count++;
            else{
                map = new HashMap<>();
                if (largeMap.get(count) == null)
                    map.put(0, result.get(i - 1));
                else{
                    map = largeMap.get(count);
                    map.put(largeMap.get(count).size(), result.get(i - 1));
                }
                largeMap.put(count,map);
                if ( count > max ) max = count;
                if ( count < min ) min = count;
                count = 1;
                a = result.get(i);
            }
        }
        if ( result.get(s.length()-2) != result.get(s.length()-1) ) count = 1;
        map = new HashMap<>();
        if (largeMap.get(count) == null)
                map.put(0, result.get(s.length()-1));
        else{
            map = largeMap.get(count);
            map.put(largeMap.get(count).size(), result.get(s.length() - 1));
            }
            largeMap.put(count,map);
            if ( count > max ) max = count;
            if ( count < min ) min = count;
            count = 1;
        StringBuilder out = new StringBuilder();
        int start = max;
        while ( start <= max && start >= min ){
            if ( largeMap.get(start) != null )
                for ( int j = 0; j < largeMap.get(start).size();j++ )
                    for ( int i = 0; i < start; i++ )
                        out.append(largeMap.get(start).get(j));
            start--;
        }
    return(out.toString());
    }
}