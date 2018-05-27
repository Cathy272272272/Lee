class 371SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if ( a > b ) {
            int temp = a;
            a = b;
            b = temp;
        }
        do{
            a--;
            b++;
        }while ( a != 0 );
        return b;
    }
}