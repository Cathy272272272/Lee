class 812LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        if ( points.length < 3 || points.length > 50 ) return 0.0;
        double maxArea = 0;
        double temp = 0.0;
        int[] a = points[0];
        for ( int i = 0; i < points.length && check(points[i]); i++ ){
            for ( int j = i + 1; j < points.length && check(points[j]); j++ ){
                for ( int k = j + 1; k < points.length && check(points[k]); k++ ){
                    temp = area(points[i], points[j], points[k]);
                    if ( maxArea < temp )
                        maxArea = temp;
                }
            }
        }
        return maxArea;
    }
    public boolean check( int[] points ) {
        if (Math.abs(points[0]) <= 50 && Math.abs(points[1]) <= 50 ) return true;
        else return false;
    }
    public double area(int[]a, int[]b, int[]c) {
        if (a[0] == b[0] && b[0] == c[0] ) return 0;
        double area;
        int[] yMax, yMid, yMin;
        if ( a[0] > b[0] ){
            if  ( a[0] > c[0] ) { yMax = a; if ( b[0] > c[0] ) { yMid = b; yMin = c;} else { yMid = c; yMin = b;}} 
            else { yMax = c; yMid = a; yMin = b;}
        }
        else {
            if ( b[0] > c[0] ) { yMax = b; if ( a[0] > c[0] ) { yMid = a; yMin = c;} else { yMid = c; yMin = a;}}
            else { yMax = c; yMid = b; yMin = a; }
        }
        if ( !((yMid[1] > yMax[1] && yMid[1] > yMin[1]) || (yMid[1] < yMax[1] && yMid[1] < yMin[1])) ) {
            area = Math.abs(0.5 * ( yMax[0] - yMin[0] )* ( ( yMax[1] - yMid[1]) - ( yMax[0] - yMid[0]  ) / ( yMax[0] - yMin[0] + 0.0 ) * ( yMax[1] - yMin[1] )));
        }
        else{
            area = Math.abs(0.5 * ( yMax[0] - yMin[0] )* ( ( yMid[1] - yMin[1]) - ( yMid[0] - yMin[0] ) / ( yMax[0] - yMin[0] + 0.0 ) * ( yMax[1] - yMin[1])));
            System.out.println(area);
        }
        return area;
        }
    }
