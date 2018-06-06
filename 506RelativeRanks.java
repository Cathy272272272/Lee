class 506RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for ( int i = 0; i < n; i++ )
            map.put(nums[i], i);
        Arrays.sort(nums);
        String[] res = new String[n];
        
        if ( n >= 1 ) res[map.get(nums[n - 1])] = "Gold Medal";
        if ( n >= 2 ) res[map.get(nums[n - 2])] = "Silver Medal";
        if ( n >= 3 ) res[map.get(nums[n - 3])] = "Bronze Medal";
        if ( n >= 4 )
        for (int i = 0; i < n - 3; i++ ) {
            res[map.get(nums[i])] = Integer.toString(n-i);
        }
        return res;
    }
}