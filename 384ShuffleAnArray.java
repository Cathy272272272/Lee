class 384ShuffleAnArray {
    int[] sol;
    int[] copy;
    int size;
    public Solution(int[] nums) {
        size = nums.length;
        sol = new int[size];
        copy = new int[size];
        size = 0;
        for ( int i : nums ){
            sol[size] = i;
            copy[size] = i;
            size++;
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for ( int i = 0; i < size; i++ )
            sol[i] = copy[i];
        return sol;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random r = new Random();
        for ( int i = 0; i < size; i++ ) {
            int index = i + r.nextInt(size - i);
            int tmp = sol[i];
            sol[i] = sol[index];
            sol[index] = tmp;
        }
        return sol;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */