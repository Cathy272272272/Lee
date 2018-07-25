/*Two Queue and add all the Pacific border to one queue; Atlantic border to another queue.
Keep a visited matrix for each queue. In the end, add the cell visited by two queue to the result.
BFS: Water flood from ocean to the cell. Since water can only flow from high/equal cell to low cell, add the neighboor cell with height larger or equal to current cell to the queue and mark as visited.
public class Solution {
    int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        //One visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for(int i=0; i<n; i++){ //Vertical border
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m-1});
            pacific[i][0] = true;
            atlantic[i][m-1] = true;
        }
        for(int i=0; i<m; i++){ //Horizontal border
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{n-1, i});
            pacific[0][i] = true;
            atlantic[n-1][i] = true;
        }
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(new int[]{i,j});
            }
        }
        return res;
    }
    public void bfs(int[][]matrix, Queue<int[]> queue, boolean[][]visited){
        int n = matrix.length, m = matrix[0].length;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] d:dir){
                int x = cur[0]+d[0];
                int y = cur[1]+d[1];
                if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]){
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            } 
        }
    }
}
DFS version:

public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][]pacific = new boolean[n][m];
        boolean[][]atlantic = new boolean[n][m];
        for(int i=0; i<n; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
        }
        for(int i=0; i<m; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
        }
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                if (pacific[i][j] && atlantic[i][j]) 
                    res.add(new int[] {i, j});
        return res;
    }
    
    int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
        int n = matrix.length, m = matrix[0].length;
        if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for(int[]d:dir){
            dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
        }
    }
}*/
class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        int m = matrix.length;
        if ( m == 0 ) return list;
        int n = matrix[0].length;
        if ( n == 0 ) return list;
        boolean[][] v0 = new boolean[m][n];
        boolean[][] v1 = new boolean[m][n];
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                if ( p(matrix, p, v0, i, j) && a(matrix, a, v1, i, j) ) list.add(new int[]{i, j});
            }
        }
        return list;
    }
    public boolean p(int[][] matrix, boolean[][] p, boolean[][] v, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length; 
        if ( i == 0 || j == 0 ) {
            p[i][j] = true;
            return true;
        }
        if ( p[i][j] ) return p[i][j];
        v[i][j] = true;
        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for ( int k = 0; k < 4; k++ ) {
            int x = i + moves[k][0];
            int y = j + moves[k][1];
            if ( x >= m || y >= n ) continue;
            if ( matrix[x][y] > matrix[i][j] ) continue;
            if ( matrix[x][y] == matrix[i][j] ) {
                if ( p[x][y] ) {
                    p[i][j] = true;
                    return true;
                }
                if ( v[x][y] ) continue;
                else if ( p(matrix, p, v, x, y) ) {
                    p[i][j] = true;
                    return true;
                }
            }            
            if ( p(matrix, p, v, x, y) ) {
                p[i][j] = true;
                return true;
            }
        }
        p[i][j] = false;
        return false;          
    }
    public boolean a(int[][] matrix, boolean[][] p, boolean[][] v, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length; 
        if ( i == m - 1 || j == n - 1 ) {
            p[i][j] = true;
            return true;
        }
        if ( p[i][j] ) return p[i][j];
        v[i][j] = true;
        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for ( int k = 0; k < 4; k++ ) {
            int x = i + moves[k][0];
            int y = j + moves[k][1];
            if ( x < 0 || y < 0 ) continue;
            if ( matrix[x][y] > matrix[i][j] ) continue;
            if ( matrix[x][y] == matrix[i][j] ) {
                if ( p[x][y] ) {
                    p[i][j] = true;
                    return true;
                }
                if ( v[x][y] ) continue;
                else if ( a(matrix, p, v, x, y) ) {
                    p[i][j] = true;
                    return true;
                }
            }
            if ( a(matrix, p, v, x, y) ) {
                p[i][j] = true;
                return true;
            }
        }
        p[i][j] = false;
        return false;
    }
}