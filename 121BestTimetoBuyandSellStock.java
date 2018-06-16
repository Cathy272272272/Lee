/*Mine is sososlow......
 * The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm. Since no body has mentioned this so far, I thought it's a good thing for everybody to know.

All the straight forward solution should work, but if the interviewer twists the question slightly by giving the difference array of prices, Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, you might end up being confused.

Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.

    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
*maxCur = current maximum value

*maxSoFar = maximum value found so far
* */
class 121BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if ( n == 0 ) return 0;
        if ( n == 1 ) return 0;
        int[] dis = new int[n-1];
        return Math.max(0, distance(prices, 0, dis));
    }
    public int distance(int[] prices, int i, int[] dis) {
        int n = prices.length;
        if ( i == n - 1) return dis[n-2];
        for ( int j = i + 1; j < n; j++ )
            dis[i] = Math.max(dis[i], prices[j] - prices[i]);
        if ( i != 0 ) dis[i] = Math.max(dis[i], dis[i-1]);
        return distance(prices, i+1, dis);
    }
}