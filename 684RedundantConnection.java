/*
 * boolean[] needs to be reset for every option, it is a poiinter, so I guess int[] and other arrays are also like this...
 */
/*
 * unionfind solution
 class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        int mark = 0, i = 0;
        for (int[] edge: edges){
            int f = edge[0], t = edge[1];
            if (find(parent, f) == find(parent, t)) mark = i;
            else parent[find(parent, f)] = find(parent, t);
            i++;
        }
        
        return edges[mark];
    }
    
    private int find(int[] parent, int f) {
        if (f != parent[f]) {
          parent[f] = find(parent, parent[f]);  
        }
        return parent[f];
    }
}
*/
    
class 684RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        boolean[] visit = new boolean[n];
        if ( n == 1 || n == 2 ) return edges[0];
        for ( int i = n - 1; i >= 0; i-- ) {
            visit = new boolean[n];
            boolean a = friend(edges, i,  i, edges[i][0], visit);
            visit = new boolean[n];
            boolean b = friend(edges, i, i, edges[i][1], visit);
            if ( !a && !b ) return edges[i];
        }
        return null;
    }
    public boolean friend(int[][] edges, int tar, int cur, int checkcur, boolean[] visit) {
        System.out.println(cur);
        int n = edges.length;
        for ( int i = 0; i < n; i++ ) {
            if ( i == cur || i == tar ) continue;
            if ( edges[i][0] == checkcur ) {
                if ( visit[i]) return true;
                visit[i] = true;
                if (friend(edges, tar, i, edges[i][1], visit)) return true;
            }
            if ( edges[i][1] == checkcur ) {
                if ( visit[i]) return true;
                visit[i] = true;
                if (friend(edges, tar,  i, edges[i][0], visit)) return true;
            }
        }
        return false;
    }

}