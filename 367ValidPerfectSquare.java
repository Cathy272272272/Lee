class 367ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if ( num == 1 ) return true;
        long l = 0, h = num, m;
        while ( l < h ) {
            m = ( l + h ) / 2;
            if ( m * m >= (long)num ) {
                h = m;
            }
            else l = m + 1;
        }
        return h * h == (long)num;
    }
}
/* Newton's method
 * let xn^2 - S = 0, use equation xn+1 = xn - f(xn)/f'(xn);
 *Python

    r = x
    while r*r > x:
        r = (r + x/r) / 2
    return r*r == x
     */
     