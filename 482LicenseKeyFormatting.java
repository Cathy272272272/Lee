class 482LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        int n = S.length();
        StringBuilder tmp = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for ( int i = n - 1; i >= 0; i-- ) {
            if ( S.charAt(i) == '-' ) continue;
            tmp.append(S.charAt(i));
            if ( tmp.length() == K ) {
                ans.append(tmp).append("-");
                tmp.delete(0, K);
            }
        }
        if ( ans.length() == 0 ) {
            if ( tmp.length() == 0 ) return "";
            return tmp.reverse().toString().toUpperCase();
        }
        if ( tmp.length() == 0 ) return ans.delete(ans.length() - 1, ans.length()).reverse().toString().toUpperCase();
        return ans.append(tmp).reverse().toString().toUpperCase();
    }
}