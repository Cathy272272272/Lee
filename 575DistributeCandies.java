/*
 * Math.min() faster than (a < b ) ? a : b
 * errr....Really? I don't know......
 */
/*
 * public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) kinds.add(candy);
        return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
    }
}
*/
/*
 * var distributeCandies = function(candies) {
    return Math.min(new Set(candies).size, candies.length / 2);
};*/
class 575DistributeCandies{
    public int distributeCandies(int[] candies) {
        //int[] array = new int[candies.length];
        Arrays.sort(candies);
        int count = 0;
        for ( int i = candies.length - 1; i > 0; i-- )
            if ( candies[i] != candies[i - 1] )
                count++;
        return ( Math.min( ++count, candies.length / 2 ));
        
            
    }
}