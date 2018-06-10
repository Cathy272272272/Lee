class 409LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] alphabet = new int[52];
        int n = s.length(), tmp;
        for ( int i = 0; i < n; i++ ) {
            tmp = s.charAt(i);
            if ( tmp <= 'Z' )
                alphabet[tmp - 'A']++;
            else
                alphabet[26 + tmp - 'a']++;
        }
        int sum = 0, max = 0;
        for ( int i = 0; i < 52;i++) {
            if ( alphabet[i] % 2 == 0 ) {
                sum += alphabet[i];
            }
            else {
                max = 1;
                sum += alphabet[i] - 1;
            }
        }
        return sum + max;
    }
}