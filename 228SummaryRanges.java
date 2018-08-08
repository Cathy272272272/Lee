class 228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> list = new ArrayList<>();
        if ( n == 0 ) return list;
        int help = nums[0];
        for ( int i = 1; i < n; i++ ) {
            if ( nums[i] > nums[i-1] + 1 ) {
                if ( nums[i-1] == help ) list.add(String.valueOf(help));
                else list.add(String.valueOf(help).concat("->").concat(String.valueOf(nums[i-1])));
                help = nums[i];
            }
        }
        if ( nums[n-1] == help ) list.add(String.valueOf(help));
        else list.add(String.valueOf(help).concat("->").concat(String.valueOf(nums[n-1])));
        return list;
    }
}