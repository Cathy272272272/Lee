/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long l = 1, h = n, m = (l+h)/2;
        int res = -1;
        while ( l < h ) {
            m = (l+h)/2; 
            res = guess((int)m);
            if ( res <= 0 ) h = m;
            else if ( res > 0 ) l = m + 1;
        }
        return (int)h;
    }
}