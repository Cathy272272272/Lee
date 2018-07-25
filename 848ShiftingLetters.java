class 848ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        StringBuilder ans = new StringBuilder();
        int n = shifts.length;
        if ( n == 0 ) return S;
        shifts[n-1] %= 26;
        for ( int i = n - 2; i >= 0; i-- ) {
            shifts[i] += shifts[i+1];
            shifts[i] %= 26;
        }
        for ( int i = 0; i < n; i++ ) {
            int tmp = S.charAt(i) + shifts[i];
            ans.append((char)(tmp > 122 ? tmp - 26 : tmp));
        }
        return ans.toString();
    }
}