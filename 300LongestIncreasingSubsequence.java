/*
 * tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:

len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
len = 3   :      [4, 5, 6]            => tails[2] = 6
We can easily prove that tails is a increasing array. Therefore it is possible to do a binary search in tails array to find the one needs update.

Each time we only do one of the two:

(1) if x is larger than all tails, append it, increase the size by 1
(2) if tails[i-1] < x <= tails[i], update tails[i]
Doing so will maintain the tails invariant. The the final answer is just the size.

Java

public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int x : nums) {
        int i = 0, j = size;
        while (i != j) {
            int m = (i + j) / 2;
            if (tails[m] < x)
                i = m + 1;
            else
                j = m;
        }
        tails[i] = x;
        if (i == size) ++size;
    }
    return size;
}
// Runtime: 2 ms
*/
class 300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if ( n == 0 || n == 1 ) return n;
        int min = nums[0], max = 1, count = 1, j;
        for ( j = 1; j < n; j++ ) {
            if ( nums[j] > nums[j-1] ) count++;
            else break;
        }
        if ( j == n ) return count;
        max = help(nums);
        for ( int i = 1; i < n; i++ ) {
            if ( nums[i] < min ) {
                min = nums[i];
                max = Math.max(max, help(Arrays.copyOfRange(nums, i, n)));
            }
        }
        return Math.max(max, count);
    }
    public int help(int[] nums) {
        int n = nums.length;
        if ( n == 0 || n == 1 ) return n;
        int max = 1;
        for ( int i = 1; i < n; i++ ) {
            if ( nums[i] > nums[0] ) {
                max = Math.max(max, 1 + help(Arrays.copyOfRange(nums, i, n)));
            }
        }
        return max;
    }
}