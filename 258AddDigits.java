class 258AddDigits {
    public int addDigits(int num) {
        if (num == 0) return 0;
        return ( (num %= 9) != 0 ? num : 9);
    }
}