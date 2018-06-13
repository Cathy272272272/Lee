/* Finally understand, so clever...
 * 
 * the hard point is why the second loop ensure that the meeting point is the duplicate number.
 * that is because, when fast meets the slow, it means the fast runs exactly one more loop than the slow.
 * so the remaining distance for the slow equals the distance between position 0 to the entry of the cycle.
 * since 2 * ( 0 to entry + entry to the current position of slow in the loop) = 0 to entry + entry to current position of fast 
 * = 0 to entry + 2 * entry to the current position of slow + the remaining distance of slow to the end of the loop
 * The main idea is the same with problem Linked List Cycle II,https://leetcode.com/problems/linked-list-cycle-ii/. Use two pointers the fast and the slow. The fast one goes forward two steps each time, while the slow one goes only step each time. They must meet the same item when slow==fast. In fact, they meet in a circle, the duplicate number must be the entry point of the circle when visiting the array from nums[0]. Next we just need to find the entry point. We use a point(we can use the fast one before) to visit form begining with one step each time, do the same job to slow. When fast==slow, they meet at the entry point of the circle. The easy understood code is as follows.

int findDuplicate3(vector<int>& nums)
{
 if (nums.size() > 1)
 {
  int slow = nums[0];
  int fast = nums[nums[0]];
  while (slow != fast)
  {
   slow = nums[slow];
   fast = nums[nums[fast]];
  }

  fast = 0;
  while (fast != slow)
  {
   fast = nums[fast];
   slow = nums[slow];
  }
  return slow;
 }
 return -1;
}
*/

class 287FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, i = 0;
        if ( n == 0 ) return 0;
        for ( i = 0; i < n - 1; i++ )
            if ( nums[i] == nums[i+1])
                break;
        return nums[i];
    }
}