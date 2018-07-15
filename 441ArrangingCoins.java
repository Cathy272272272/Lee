class 441ArrangingCoins {
    public int arrangeCoins(int n) {
        return count(n, 1);
    }
    public int count(int n, int l) {
        if ( n < l ) return 0;
        return 1 + count(n-l, l + 1);
    }
}