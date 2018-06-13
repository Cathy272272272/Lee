/*Clever......Today is notmy day......
 * Simply find out the three largest numbers and the two smallest numbers using one pass.

    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
    */
class 628MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        if ( n < 3 ) return 0;
        Integer[] res = Arrays.stream( nums ).boxed().toArray( Integer[]::new );
        //Integer[] ever = IntStream.of( data ).boxed().toArray( Integer[]::new );
        Arrays.sort(res, (Integer s1, Integer s2) -> Math.abs(s2) - Math.abs(s1));
        int tmp = 0;
        for ( int i = 0; i < n - 2; i++ ) {
            tmp = res[0] * res[1] * res[i+2];
            if ( tmp > 0 )
                return tmp;
        }
        return tmp;      
    }
}