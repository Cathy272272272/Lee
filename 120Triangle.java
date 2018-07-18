/*
 * public int minimumTotal(List<List<Integer>> triangle) {
    int[] A = new int[triangle.size()+1];
    for(int i=triangle.size()-1;i>=0;i--){
        for(int j=0;j<triangle.get(i).size();j++){
            A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
        }
    }
    return A[0];
}
*/
class 120Triangle {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size(), min = Integer.MAX_VALUE;
        if ( n == 1 ) {
            return t.get(0).get(0);
        }
        List<Integer> list = new ArrayList<>();
        for ( int i = 0; i < n; i++ ) {
            if ( i == 0 ) {
                list.add(t.get(0).get(0));
                continue;
            }
            List<Integer> tmp = t.get(i);
            for ( int j = 0; j <= i; j++ ) {
                if ( j == 0 ) list.add(0, list.get(0) + tmp.get(0));
                else if ( j == i ) list.set(j, list.get(j) + tmp.get(j));
                else list.set(j, tmp.get(j) + Math.min(list.get(j), list.get(j+1)));
                if ( i == n - 1 ) {
                    min = Math.min(min, list.get(j));
                }
            }
            System.out.println(list);
        }
        return min;
    }
}