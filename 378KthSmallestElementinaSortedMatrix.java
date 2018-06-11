/* so brilliant......
 * public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = getLessEqual(matrix, mid);
            if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
    
    private int getLessEqual(int[][] matrix, int val) {
        int res = 0;
        int n = matrix.length, i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > val) i--;
            else {
                res += i + 1;
                j++;
            }
        }
        return res;
    }
}
*/
class 378KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if ( n == 1 ) return matrix[0][0];
        int r = 0, c = 0, i = 0, j = 0;
        List<Integer> list = new ArrayList<Integer>();
        for ( i = 0; i < n; i++ ) {
            for ( j = i; j < n; j++){
                if ( (n - i )*(n - j ) - 1 <= n * n - k ) {
                    list.add(matrix[i][j]);
                if ( i != j )
                    list.add(matrix[j][i]);
                }
            }
        }
        Collections.sort(list);
        return list.get(k - n * n + list.size() - 1);
    }
}