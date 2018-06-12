class 6502KeysKeyboard {
    public int minSteps(int n) {
        if ( n == 0 || n == 1) return 0;
        int i;
        for ( i = 2; i <= n; i++ ) 
            if ( n % i == 0 )
                break;
        return i + minSteps(n/i);
    }
}