/*
 * Just find the square of lenghts, and validate that

There are only two equal longest lenghts.

The non longest lengths are all equal.

public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
long[] lengths = {length(p1, p2), length(p2, p3), length(p3, p4),
length(p4, p1), length(p1, p3),length(p2, p4)}; // all 6 sides

 long max = 0, nonMax = 0;
 for(long len : lengths) {
     max = Math.max(max, len);
 }
 int count = 0;
 for(int i = 0; i < lengths.length; i++) {
     if(lengths[i] == max) count++;
     else nonMax = lengths[i]; // non diagonal side.
 }
 if(count != 2) return false; // diagonals lenghts have to be same.

 for(long len : lengths) {
     if(len != max && len != nonMax) return false; // sides have to be same length
 }
 return true;
}
private long length(int[] p1, int[] p2) {
return (long)Math.pow(p1[0]-p2[0],2) + (long)Math.pow(p1[1]-p2[1], 2);
}
*/
class 593ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<int[]> list = new ArrayList<int[]>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        Collections.sort(list, (x,y) -> {
            int cmp = x[0] - y[0];
            if ( cmp == 0 ) cmp = x[1] - y[1];
            return cmp;
        });
        for ( int i = 1; i < 4; i++ ) if ( list.get(i)[0] == list.get(i-1)[0] && list.get(i)[1] == list.get(i-1)[1] ) return false;
        return check(list);
    }
    public boolean check(List<int[]> list) {
        int[] a = list.get(0);
        int[] b = list.get(1);
        int[] c = list.get(2);
        int[] d = list.get(3);
        int d1 = (a[0] - d[0]) * (a[0] - d[0]) + (a[1] - d[1]) * (a[1] - d[1]);
        int d2 = (b[0] - c[0]) * (b[0] - c[0]) + (b[1] - c[1]) * (b[1] - c[1]);
        return d1 == d2 && Math.abs((a[1] - d[1]) * (b[1] - c[1])) == Math.abs((a[0] - d[0]) * (b[0] - c[0])) && Math.abs((a[1] - b[1]) * (a[1] - c[1])) == Math.abs((a[0] - b[0]) * (a[0] - c[0]));
    }
}