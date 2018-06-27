/*
 * class Solution {
    public int dominantIndex(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        if(nums.length == 1){
            return 0;
        }
        int max = Integer.MIN_VALUE + 1;
        int secondMax = Integer.MIN_VALUE;
        int index = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                secondMax = max;
                max = nums[i];
                index = i;
            } else if(nums[i] != max && nums[i] > secondMax){
                secondMax = nums[i];
            }
        }
        if(secondMax * 2 <= max){
            return index;
        }
        return -1;
    }
}
*/
class 747LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        if ( n < 1 || n > 50 ) return -1;
        if ( n == 1 ) return 0;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for ( int i = 0; i < n; i++ ) map.put(nums[i], i);
        int last = map.lastKey();
        if ( last >= 2 * map.lowerKey(last) ) return map.get(last);
        return -1;
    }
}