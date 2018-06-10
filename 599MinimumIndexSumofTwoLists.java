// list.toArray(new T[])
// StringBuilder delete() faster than new StringBuilder()
/* Mine is slow......
 * public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    List<String> res = new LinkedList<>();
    int minSum = Integer.MAX_VALUE;
    for (int i=0;i<list1.length;i++) map.put(list1[i], i);
    for (int i=0;i<list2.length;i++) {
        Integer j = map.get(list2[i]);
        if (j != null && i + j <= minSum) {
            if (i + j < minSum) { res.clear(); minSum = i+j; }
            res.add(list2[i]);
        }
    }
    return res.toArray(new String[res.size()]);
    */
class 599MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int count1 = 0, count2 = 0;
        for ( String i: list1 ) {
            count2 = 0;
            for ( String j :list2 ) {
                if ( i.equals(j) ) {
                    map.put(i, count1 + count2);
                    break;
                }
                count2++;
            }
            count1++;
        }
        int min = list1.length + list2.length;
        List<String> list = new ArrayList<String>();
        for (String s : map.keySet()) {
            int tmp = map.get(s);
            if (tmp < min ) {
                min = tmp;
                list.clear();
                list.add(s);
            }
            else if (tmp == min )
                list.add((s));
        }
        return list.toArray(new String[list.size()]);
    }
}