/*
 * doing this for hours, when accepted, I just want to cry......
 * 
 *     private int count = 0;
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void helper(int[] nums, int start) {
        if (start == 0) {
            count++;
            return;
        }
        for (int i = start; i > 0; i--) {
            swap(nums, start, i);
            if (nums[start] % start == 0 || start % nums[start] == 0) helper(nums, start-1);
            swap(nums,i, start);
        }
    }
    public int countArrangement(int N) {
        if (N == 0) return 0;
        int[] nums = new int[N+1];
        for (int i = 0; i <= N; i++) nums[i] = i;
        helper(nums, N);
        return count;
    }
    Forgive me, I will see others' answers in the future......
    */
class 526BeautifulArrangement {
    int count = 0;
    public int countArrangement(int N) {
        if ( N > 15 || N <= 0 ) return 0;
        tree(1, N, new boolean[N]);
        return count;
    }
    public void tree ( int depth, int n, boolean[] used) {
        if ( depth <= n )
            for ( int i = 1; i <= n; i++ )
                if (!used[i - 1] && ( i % depth == 0 || depth % i == 0 ))
                    used[i - 1] = true;
                    tree(depth + 1, n, used);
                    used[i-1] = false;
        else count++;
    }
}
