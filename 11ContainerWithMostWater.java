/*
 * AKA, the general idea to find some max is to go through all cases where max value can possibly occur and keep updating the max value. The efficiency of the scan depends on the size of cases you plan to scan.
To increase efficiency, all we need to do is to find a smart way of scan to cut off the useless cases and meanwhile 100% guarantee the max value can be reached through the rest of cases.

In this problem, the smart scan way is to set two pointers initialized at both ends of the array. Every time move the smaller value pointer to inner array. Then after the two pointers meet, all possible max cases have been scanned and the max situation is 100% reached somewhere in the scan. Following is a brief prove of this.

Given a1,a2,a3.....an as input array. Lets assume a10 and a20 are the max area situation. We need to prove that a10 can be reached by left pointer and during the time left pointer stays at a10, a20 can be reached by right pointer. That is to say, the core problem is to prove: when left pointer is at a10 and right pointer is at a21, the next move must be right pointer to a20.

Since we are always moving the pointer with the smaller value, i.e. if a10 > a21, we should move pointer at a21 to a20, as we hope. Why a10 >a21? Because if a21>a10, then area of a10 and a20 must be less than area of a10 and a21. Because the area of a10 and a21 is at least height[a10] * (21-10) while the area of a10 and a20 is at most height[a10] * (20-10). So there is a contradiction of assumption a10 and a20 has the max area. So, a10 must be greater than a21, then next move a21 has to be move to a20. The max cases must be reached.

public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
 int maxArea = 0;

 while (left < right) {
  maxArea = Math.max(maxArea, Math.min(height[left], height[right])
    * (right - left));
  if (height[left] < height[right])
   left++;
  else
   right--;
 }

 return maxArea;
}
*/
class 11ContainerWithMostWater {
    public int maxArea(int[] h) {
        int max = 0;
        int n = h.length;
        int[] dp = new int[n];
        int maxi = h[0], maxj = h[n-1];
        for ( int i = 0; i < n; i++ ) {
            if ( i > 0 ) {
                if ( h[i] <= maxi ) continue;
                else maxi = h[i];
            }
            maxj = h[n-1];
            for ( int j = n - 1; j >= i; j-- ) {
                if ( j < n - 1 ) {
                    if ( h[j] <= maxj ) continue;
                    else maxj = h[j];
                }
                max = Math.max(max, Math.min(maxj, maxi)*(j-i));
            }
        }
        return max;
    }
}