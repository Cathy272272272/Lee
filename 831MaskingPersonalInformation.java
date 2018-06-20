/*
 *     String[] country = {"", "+*-", "+**-", "+***-"};
    public String maskPII(String S) {
        int at = S.indexOf("@");
        if (at > 0) {
            S = S.toLowerCase();
            return (S.charAt(0) + "*****" + S.substring(at - 1)).toLowerCase();
        }
        S = S.replaceAll("[^0-9]", "");
        return country[S.length() - 10] + "***-***-" + S.substring(S.length() - 4);
    }
    */
class 831MaskingPersonalInformation {
    public String maskPII(String S) {
        int n = S.length();
        if ( n > 40 || n == 0 ) return "";
        if ( S.contains("@") ) return email(S);
        return phone(S);
    }
    public String email(String S) {
        String[] a = S.toLowerCase().split("@");
        return a[0].substring(0,1).concat("*****").concat(a[0].substring(a[0].length()-1)).concat("@").concat(a[1]);
    }
    public String phone (String S) {
        StringBuilder a = new StringBuilder();
        for ( char c : S.toCharArray() ) {
            if ( c - '0' >= 0 && c - '0' <= 9 ) {
                a.append(c);
            }
        }
        int n = a.length();
        StringBuilder tmp = new StringBuilder();
        if ( n == 10 ) return tmp.append("***-***-").append(a.substring(n-4)).toString();
        if ( n == 11 ) return tmp.append("+*-***-***-").append(a.substring(n-4)).toString();
        if ( n == 12 ) return tmp.append("+**-***-***-").append(a.substring(n-4)).toString();
        return tmp.append("+***-***-***-").append(a.substring(n-4)).toString();
    }
}