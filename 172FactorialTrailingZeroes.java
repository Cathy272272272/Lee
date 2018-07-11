class 172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if ( n == 0 ) return 0;
        long nn = (long)n;
        long pow = 5;
        int count = 0;
        while ( nn / pow > 0 ) {
            count += (int)(n / pow);
            pow *= 5;
        }
        return count;
    }
}