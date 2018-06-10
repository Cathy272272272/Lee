class 357CountNumberswithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if ( n == 0 ) return 1;
        if ( n == 1 ) return 10;
        int fac = 9, count = 9, down = 10 - n;
        while ( count > down) 
            fac *= count--;
        return fac + countNumbersWithUniqueDigits(n - 1);
        
    }
}