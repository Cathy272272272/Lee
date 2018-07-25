/*
 * Use binary search.

n * m matrix convert to an array => matrix[x][y] => a[x * m + y]

an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];

class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        int n = matrix.size();
        int m = matrix[0].size();
        int l = 0, r = m * n - 1;
        while (l != r){
            int mid = (l + r - 1) >> 1;
            if (matrix[mid / m][mid % m] < target)
                l = mid + 1;
            else 
                r = mid;
        }
        return matrix[r / m][r % m] == target;
    }
};
*/
class 74Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if ( m == 0 ) return false;
        int n = matrix[0].length;
        if ( n == 0 ) return false;
        int l = 0, h = m - 1;
        while ( l < h ) {
            int mid = (l+h)/2;
            if ( matrix[mid][0] >= target ) h = mid;
            else l = mid + 1;
        }
        if ( matrix[l][0] == target ) return true;
        if ( l == 0 && m != 1 ) return false;
        if ( l == 0 || matrix[l][0] <= target ) l++;
        int ll = 0, hh = n - 1;
        while ( ll < hh ) {
            int mid = (ll+hh)/2;
            if ( matrix[l-1][mid] >= target ) hh = mid;
            else ll = mid + 1;            
        }
        return matrix[l-1][ll] == target;
    }
}