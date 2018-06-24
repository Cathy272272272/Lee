/* This is O(n^2), mine is O(n^3)......
 * public static int triangleNumber(int[] A) {
    Arrays.sort(A);
    int count = 0, n = A.length;
    for (int i=n-1;i>=2;i--) {
        int l = 0, r = i-1;
        while (l < r) {
            if (A[l] + A[r] > A[i]) {
                count += r-l;
                r--;
            }
            else l++;
        }
    }
    return count;
}
*/
class 611ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if ( n < 3 || n > 1000 ) return 0;
        Arrays.sort(nums);
        int count = 0;
        for ( int i = 0; i < n - 2; i++ ) {
            for ( int j = i + 1; j < n - 1; j++ ) {
                for ( int k = n - 1; k > j; k-- ) {
                    if ( nums[i] + nums[j] > nums[k] ) {
                        count += ( k - j);
                        break;
                    }
                }
            }
        }
        return count;
    }
}