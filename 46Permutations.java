class 46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if ( nums.length == 0 ) return null;
        int size = nums.length;
        List<Integer> tmp;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if ( nums.length == 1 ) {
            tmp = new ArrayList<Integer>();
            tmp.add(nums[0]);
            res.add(tmp);
            return res;
        }
        int ele = nums[0];
        int[] use = Arrays.copyOfRange(nums,1, size);
        List<List<Integer>> help = new ArrayList<List<Integer>>(permute(use));
        for ( List<Integer> j : help ) {
            for ( int i = 0; i < size; i++ ) {
                tmp = new ArrayList<Integer>();
                tmp.addAll(j);
                tmp.add(i,ele);
                res.add(tmp);
            }
        }
        return res;
    }
}