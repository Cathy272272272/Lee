/*DFS
 * public class Solution {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}

Union Find
public class Solution {
    class UnionFind {
        private int count = 0;
        private int[] parent, rank;
        
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int p) {
         while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            }
            else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
            count--;
        }
        
        public int count() {
            return count;
        }
    }
    
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }
}
*/
class 547FriendCircles {
    public int findCircleNum(int[][] M) {
        if ( M.length < 1 || M.length > 200 ) return 0;
        int length = M.length;
        boolean changed = true;
        int count = 0;;
        while ( changed ) {
            changed = false;
            count++;
        for ( int i = 0; i < length; i++ ) 
            for ( int j = 0; j < length; j++ ) 
                for ( int k = j + 1; k < length; k++ ) 
                    if ( M[i][j] == 1 && M[i][k] == 1 ) 
                        if ( M[j][k] == 0 ) {
                            changed = true;
                            M[j][k] = 1;
                            M[k][j] = 1;
                        }
        }
        int[] check = new int[length];
        count = 0;
        int rs = 0;
        boolean help;
        for ( int i = 0; i < length; i++ ) {
            help = false;
            for ( int j = 0; j < length; j++ ) {
                if ( M[i][j] == 1 ) 
                    if ( check[j] == 0 ) {
                        help = true;
                        check[j] = 1;
                        count++;
                    }
            }
            if ( help )
                rs++;
            if ( count == length ) return rs;
        }
        return rs;
    }
}