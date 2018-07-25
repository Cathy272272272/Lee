class 67AddBinary {
    public String addBinary(String a, String b) {
        int al = a.length(), bl = b.length();
        int max = Math.max(al, bl);
        int at, bt, c = 0;
        StringBuilder ans = new StringBuilder();
        for ( int i = 0; i < max; i++ ) {
            at = 0;
            bt = 0;
            if ( i < al ) {
                at = a.charAt(al - 1 - i) - '0';
            }
            if ( i < bl ) {
                bt = b.charAt(bl - 1 - i) - '0';
            }
            int tmp = at + bt + c;
            if ( tmp >= 2 ) {
                c = 1;
                tmp -= 2;
            }
            else c = 0;
            ans.append(tmp);
        }
        if ( c == 1 ) ans.append(1);
        return ans.reverse().toString();
    }
}