class 38CountandSay {
    public String countAndSay(int n) {
        if ( n == 1 ) return "1";
        String s = countAndSay(n-1);
        StringBuilder ans = new StringBuilder();
        int l = s.length();
        boolean check = false;
        char tmp = s.charAt(0);
        int count = 1;
        for ( int i = 1; i < l; i++ ) {
            if ( tmp == s.charAt(i) ) count++;
            else {
                ans.append(count).append(tmp);
                tmp = s.charAt(i);
                count = 1;
            }
        }
        ans.append(count).append(tmp);
        return ans.toString();
    }
}