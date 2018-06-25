/*
 * The idea is to keep a count of each word in a HashMap and then insert in a Priority Queue.
While inserting in pq, if the count of two words is same then insert based on string compare of the keys.

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        {
            if(map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                 (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );
        
        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());
        
        return result;
    }
}
*/
class 692TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for ( String i : words ) map.put(i, map.getOrDefault(i, 0) + 1);
        List<Map.Entry<String, Integer>> entries = new ArrayList(map.entrySet());
        Collections.sort(entries, (o1, o2) -> {
            int cmp = o2.getValue().compareTo(o1.getValue());
            if ( cmp == 0 ) cmp = o1.getKey().compareTo(o2.getKey());
            return cmp;
        });
        List<Map.Entry<String, Integer>> topK = entries.subList(0, Math.min(entries.size(), k));
        for ( Map.Entry<String, Integer> i : topK ) list.add(i.getKey());
        return list;
    }
}