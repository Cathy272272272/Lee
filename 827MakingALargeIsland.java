/*
 * class Solution {
    public int largestIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // create father array and size array, and initialize them
        int[] father = new int[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            father[i] = i;
        }
        int[] size = new int[rows * cols];
        Arrays.fill(size, 1);
        
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        
        // scan grid, update father array and size array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int id = i * cols + j;
                    for (int k = 0; k < 4; k++) {
                        int newi = i + dx[k];
                        int newj = j + dy[k];
                        int newid = newi * cols + newj;
                        if (isValid(rows, cols, newi, newj) && grid[newi][newj] == 1) {
                            union(father, size, id, newid);
                        }
                    }
                }
            }
        }
        
        // find current max component size
        int max = 0;
        for (int i = 0; i < size.length; i++) {
            max = Math.max(max, size[i]);
        }
        
        // find max component size if we set any 0 to 1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    int id = i * cols + j;
                    int combinedSize = 1;
                    Set<Integer> prevFather = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int newi = i + dx[k];
                        int newj = j + dy[k];
                        int newid = newi * cols + newj;
                        if (isValid(rows, cols, newi, newj) && grid[newi][newj] == 1) { 
                            int currFather = find(father, newid);
                            if (prevFather.isEmpty() || !prevFather.contains(currFather)) {
                                combinedSize += size[currFather];
                                prevFather.add(currFather);
                            }
                        }
                    }
                    max = Math.max(max, combinedSize);
                }
            }
        }
        
        // return whole size if the grid is an all 1 matrix, otherwise return the value of max
        return max == 0 ? rows * cols : max;
    }
    
    public int find(int[] father, int id) {
        if (father[id] == id) {
            return id;
        }
        return father[id] = find(father, father[id]);
    }
    
    public void union(int[] father, int[] size, int id1, int id2) {
        int fa1 = find(father, id1);
        int fa2 = find(father, id2);
        if (fa1 != fa2) {
            father[fa1] = fa2;
            size[fa2] += size[fa1];
        }
    }
    
    public boolean isValid(int rows, int cols, int i, int j) {
        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            return true;
        }
        return false;
    }
}
*/
class 827MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        if ( n < 1 || n > 50 ) return 0;
        int[] uf = new int[n*n];
        Map<Integer, Integer>map = new HashMap<Integer, Integer>();
        int tmp, max = 0, mark, a, b, c, d;
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                if ( grid[i][j] == 1 && uf[i*n + j] == 0 ) {
                    mark = uf(grid, uf, i, j, i * n + j + 1, 0);
                    map.put(i*n + j + 1, mark);
                    if ( mark > max ) max = mark;
                }
                if ( grid[i][j] == 0 ) {
                    tmp = 1;
                    a = 0;
                    b = 0;
                    c = 0;
                    d = 0;
                    if ( i - 1 >= 0 ) {
                        a = uf[(i-1)*n+j];
                        tmp += map.getOrDefault(uf[(i-1)*n+j], 0);
                    }
                    if ( j - 1 >= 0 ) {
                        b = uf[i*n + j-1];
                        if ( a != b )
                        tmp += map.getOrDefault(uf[i*n + j-1], 0);
                    }
                    if ( i + 1 < n ) {
                        c = uf[(i+1)*n+j];
                        if ( c != 0 ) {
                            if (c != b && c != a ) tmp += map.get(uf[(i+1)*n+j]);
                        }
                        else if ( grid[i+1][j] == 1 ) {
                            mark = uf(grid, uf, i+1, j, (i+1) * n + j + 1, 0);
                            map.put((i+1)*n + j + 1, mark);
                            tmp += map.get((i+1)*n + j + 1);
                            c = uf[(i+1)*n+j]; 
                        }
                    }
                    if ( j + 1 < n ) {
                        d = uf[i*n+j+1];
                        if ( d != 0 ) {
                            if( d != a && d != b && d != c ) tmp += map.get(uf[i*n+j+1]);
                        }
                        else if ( grid[i][j+1] == 1 ) {
                            mark = uf(grid, uf, i, j+1, i * n + j + 2, 0);
                            map.put(i*n + j + 2, mark);
                            tmp += map.get(i*n + j + 2);
                        }
                    } 
                    if ( tmp > max ) max = tmp;
                }
            }
        }
        return max;
    }
    public int uf(int[][] grid, int[] uf, int i, int j, int tar, int count) {
        int n = grid.length;
        if ( i < 0 || j < 0 || i >= n || j >= n ) return 0;
        if ( uf[i*n + j] != 0 ) return 0;
        if ( grid[i][j] == 0 ) return 0;
        uf[i*n + j] = tar;
        return 1 + uf(grid, uf, i+1, j, tar, count+1) + uf(grid, uf, i-1, j, tar, count+1) + uf(grid, uf, i, j+1, tar, count+1) + uf(grid, uf, i, j-1, tar, count+1);
    }
}