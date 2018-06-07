class 697DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<Integer,List<Integer>>();
        int[] index = new int[n];
        for ( int i = 0; i < n; i++ ) {
            List<Integer> tmp = new ArrayList<Integer>();
            if ( map.containsKey(nums[i])) {
                tmp = map.get(nums[i]);
                tmp.add(i);
            }
            else {
                tmp.add(i);
                map.put(nums[i], tmp);
            }
        }
        int max = 0, range = 50000;
        for ( int i : map.keySet() ) {
            List<Integer> temp = map.get(i);
            int tmp = temp.size();
            if ( tmp >= max ) {
                int help = temp.get(temp.size()-1) - temp.get(0) + 1;
                if ( !(tmp == max && range <= help) ) {
                    range = help;
                    max = tmp;
                }
            }
        }
        return range;
    }
}