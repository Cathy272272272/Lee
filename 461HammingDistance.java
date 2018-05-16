/*
 * 
 * Suggested solution......
 * public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}*/
class 461HammingDistance {
    public int hammingDistance(int x, int y) {
        int hamming = 0;
        int temp;
        if ( x >=0 && x < Math.pow( 2, 31 ) && y >= 0 && y < Math.pow( 2, 31 )){
            if ( x <= y ){//exchange x & y
                temp = x;
                x = y;
                y = temp; 
            }
            int digitsOfX = findMaxPowerTwo( x, 0 ) + 1;
            int digitsOfY = findMaxPowerTwo( y, 0 ) + 1;
            int xArray[] = new int[digitsOfX];
            int yArray[] = new int[digitsOfX];
            int countx = 0;
            int county = digitsOfX - digitsOfY;//starting position of y
            
            while ( x > 0 ){
                    temp = findMaxPowerTwo( x, 0 );
                    x -= Math.pow( 2, temp );// x minus its largest 2^n
                    xArray[countx - temp - 1 + digitsOfX] = 1; // calculate the next position
                }
            while ( y > 0){ 
                /* At first, I use if when putting in the while loop of x, it doesn't work for 7 and 10, 
                since x do less loops than y, though y < x. */
                    temp = findMaxPowerTwo( y, 0 );
                    y -= Math.pow( 2, findMaxPowerTwo( y, 0 ));
                    yArray[county - temp - 1 + digitsOfY] = 1;
                }

            for ( int i = 0; i < xArray.length; i++ ){
                if ( xArray[i] != yArray[i] )
                    hamming++;
                }       
        }
        return hamming;
    }
    public int findMaxPowerTwo(int x, int count){
        while ( x >= Math.pow( 2, count ))
            count++;
        return (count - 1) ;
    }
    
}