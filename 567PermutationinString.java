class 567PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if ( n1 > n2 ) return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for ( int i = 0; i < n1; i++ ) {
            a[s1.charAt(i)-'a']++;
            b[s2.charAt(i)-'a']++;
        }
        if (check(a, b)) return true;
        for ( int i = 0; i < n2 - n1; i++ ) {
            b[s2.charAt(i)-'a']--;
            b[s2.charAt(i+n1)-'a']++;
            if ( check(a, b)) return true;
        }
        return false;
    }
    public boolean check(int[] a, int[] b) {
        for ( int i = 0; i < 26; i++ ) {
            if ( a[i] != b[i] ) return false;
        }
        return true;
    }
}