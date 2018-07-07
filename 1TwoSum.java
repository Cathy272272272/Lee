/*
 * class Solution {
public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
        if (map.containsKey(target - numbers[i])) {
            result[1] = i;
            result[0] = map.get(target - numbers[i]);
            return result;
        }
        map.put(numbers[i], i);
    }
    return result;
}
}
*/
class 1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        //List<Integer> list = new ArrayList<>();
        //Collections.sort(list);
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int c = 0;
        for ( int i : nums ) map.put(i, c++);
        int key = map.firstKey();
        for ( int i = 0; i < n; i++ ) {
            int l = 0, h = n - 2, m, tmp = target - key;
            map.remove(key);
            //System.out.println(list);
            while ( l < h ) {
                m = ( l + h ) / 2;
                if ( map.get(map.higherKey(m)) >= tmp ) h = m;
                else l = m + 1;
            }
            //System.out.println(list.get(h));
            if ( tmp == map.get(h) ) return new int[]{i, h >= i ? h + 1 : h};
            map.put(key, target - tmp);
            key = map.higherKey(key);
            //System.out.println(list);

        }
        return new int[]{0, 0};
    }
}