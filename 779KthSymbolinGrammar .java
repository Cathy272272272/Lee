class 779K-thSymbolinGrammar {
    public int kthGrammar(int N, int K) {
        if ( N == 1 ) return 0;
        int count = (int)Math.pow(2, N-2), ini = 0;
        while ( count > 0 ) {
            if ( K > count ) {
                if ( ini == 0 ) ini = 1;
                else ini = 0;
                K -= count;
            }
            else {
                if ( ini == 0 ) ini = 0;
                else ini = 1;               
            }
            count /= 2;
        }
        return ini;
    }
}