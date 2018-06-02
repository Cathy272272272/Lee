/*
 *     public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n]; 
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }   
        return next;
    }
    */
class 503NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        List<Integer> list = new ArrayList<Integer>();
        for ( int i : nums ) list.add(i);
        for ( int i : nums ) list.add(i);
        int count, cur;
        for ( int i = 0; i < length; i++ ) {
            count = 0;
            cur = list.get(i);
            while ( count < length ) {
                count++;
                if ( list.get(count + i) > cur ) {
                    cur = list.get(count + i);
                    break;
                }
            }
            if ( cur == list.get(i) ) res[i] = -1;
            else res[i] = cur;
        }
        return res;
    }
}