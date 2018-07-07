/*
 * Our goal is trying to use two colors to color the graph and see if there are any adjacent nodes having the same color.
Initialize a color[] array for each node. Here are three states for colors[] array:
-1: Haven't been colored.
0: Blue.
1: Red.
For each node,

If it hasn't been colored, use a color to color it. Then use the other color to color all its adjacent nodes (DFS).
If it has been colored, check if the current color is the same as the color that is going to be used to color it. (Please forgive my english... Hope you can understand it.)
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);   
    
        for (int i = 0; i < n; i++) {              //This graph might be a disconnected graph. So check each unvisited node.
            if (colors[i] == -1 && !validColor(graph, colors, 0, i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != -1) {
            return colors[node] == color;
        }       
        colors[node] = color;       
        for (int next : graph[node]) {
            if (!validColor(graph, colors, 1 - color, next)) {
                return false;
            }
        }
        return true;
    }
}
*/
class 785IsGraphBipartite? {
    public boolean isBipartite(int[][] graph) {
        List<Integer> A = new ArrayList<Integer>();
        List<Integer> B = new ArrayList<Integer>();
        List<Integer> tmp;
        //List<List<Integer>> help = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int c = 0;
        for ( int[] i : graph ) {
            tmp = new ArrayList<Integer>();
            for ( int j : i ) tmp.add(j);
            if (tmp.size() > 0 ) map.put(c, tmp);
            c++;
        }
        boolean a, b;
        int n = graph.length;
        //while ( true ) {
        c = 0;
        while ( map.size() > 0 ) {
            c = 0;
            for ( int i = 0; i < n; i++ ) {
            if ( !map.containsKey(i) ) continue;
                c++;
            if ( A.contains(i) ) {
                tmp = map.get(i);
                for ( int j : tmp ) {
                    if ( A.contains(j)) return false;
                    if ( !B.contains(j)) B.add(j);
                }
                map.remove(i);
                continue;
            }
            if ( B.contains(i) ) {
                //b = true;
                tmp = map.get(i);
                for ( int j : tmp ) {
                    if ( B.contains(j)) return false;
                    if ( !A.contains(j) ) A.add(j);
                }
                map.remove(i);
                continue;
            }
            a = true;
            b = true;
            tmp = new ArrayList<Integer>();
            for ( int j : map.get(i) ) {
                tmp.add(j);
                if ( A.contains(j) ) {
                    a = false;
                }
                if ( B.contains(j) ) {
                    b = false;
                }
            }
            if ( !a || c == 1 ) {
                B.add(i);
                A.addAll(tmp);
                map.remove(i);
            }
            if ( !b ) {
                A.add(i);
                B.addAll(tmp);
                map.remove(i);
            }
            
            }
        }
        return true;
    }
}