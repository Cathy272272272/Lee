/* Mine runtime is very slow......
 * If mark the visited item, the run time should be faster......
 * public class Solution {
    public int arrayNesting(int[] a) {
        int maxsize = 0;
        for (int i = 0; i < a.length; i++) {
            int size = 0;
            for (int k = i; a[k] >= 0; size++) {
                int ak = a[k];
                a[k] = -1; // mark a[k] as visited;
                k = ak;
            }
            maxsize = Integer.max(maxsize, size);
        }

        return maxsize;
    }
}
 */
 * class 565ArrayNesting {
    public int arrayNesting(int[] nums) {
        if ( nums.length < 1 || nums.length > 20000 ) return 0;
        int max = 0;
        int count, temp, mark;
        for ( int i = 0; i < nums.length; i++ ) {
            count = 1;
            temp = i;
            while ( nums[temp] != i ) {
                temp = nums[temp];
                count++;
            }
            if ( count > max ) max = count;
            if ( max > nums.length / 2 ) break;
        }
        return max;
    }
}