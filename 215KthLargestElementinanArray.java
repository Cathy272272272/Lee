https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/
    quicksort, heapsort, many sort......
    /* Just use sort is 6ms, pq is 20 ms......
 * class Solution {
    public int findKthLargest(int[] nums, int k) {
        if ( k == 0 || nums.length == 0 ) return -1;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
*/
class 215KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        if ( k == 0 || nums.length == 0 ) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for ( int i : nums ) {
            if ( pq.size() == k ) {
                pq.add(Math.max((Integer)pq.poll(), i));
            }
            else pq.add(i);
        }
        return pq.poll();
    }
}