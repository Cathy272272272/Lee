/*
 * public List<Integer> topKFrequent(int[] nums, int k) {

 List<Integer>[] bucket = new List[nums.length + 1];
 Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

 for (int n : nums) {
  frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
 }

 for (int key : frequencyMap.keySet()) {
  int frequency = frequencyMap.get(key);
  if (bucket[frequency] == null) {
   bucket[frequency] = new ArrayList<>();
  }
  bucket[frequency].add(key);
 }

 List<Integer> res = new ArrayList<>();

 for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
  if (bucket[pos] != null) {
   res.addAll(bucket[pos]);
  }
 }
 return res;
}
*/
class 347TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> a = new HashMap<Integer, Integer>();
        Map<Integer, Map<Integer, Integer>> b = new HashMap<Integer, Map<Integer, Integer>>();
        Map<Integer, Integer> help = new HashMap<Integer, Integer>();
        List<Integer> c = new ArrayList<Integer>();
        int temp, size;
        for ( int i = 0; i < nums.length; i++ ) {
            if ( a.containsKey(nums[i]) ) {
                temp = a.get(nums[i]);
                a.put(nums[i], ++temp );
            }
            else a.put(nums[i], 1);
        }
        for ( int i : a.keySet() ) {
            temp = a.get(i);
            if ( b.containsKey(temp)) {
                help = new HashMap<Integer, Integer>(b.get(temp));
                help.put(b.get(temp).size(), i);
                b.put(temp, help);
            }
            else {
                help = new HashMap<Integer, Integer>();
                help.put(0, i);
                b.put(temp, help);
            }
        }
        int max = 0;
        for ( int i : a.keySet() ) {
            if ( a.get(i) > max )
                max = a.get(i);
        }
        while ( k > 0 ) {
            if ( b.containsKey(max) ) {
                help = b.get(max);
                for ( int i: help.keySet() ) {
                    c.add(help.get(i));
                    k--;
                }
            }
            max--;
        }
        return c;
    }
}