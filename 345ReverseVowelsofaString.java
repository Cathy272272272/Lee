class 345ReverseVowelsofaString {
    public String reverseVowels(String s) {
        List<Character> list = new ArrayList<Character>();
        list.add('a');
        list.add('o');
        list.add('e');
        list.add('i');
        list.add('u');
        list.add('A');
        list.add('O');
        list.add('E');
        list.add('I');
        list.add('U');
        int i = 0, j = s.length() - 1;
        char a = '@', b = '@';
        int marka = i, markb = j;
        StringBuilder ans = new StringBuilder(s);
        while ( i < j ) {
            if ( a == '@' && list.contains(s.charAt(i))) {
                a = s.charAt(i);
                marka = i;
            }
            if ( b == '@' && list.contains(s.charAt(j))) {
                b = s.charAt(j);
                markb = j;
            }
            if ( a != '@' && b != '@' ) {
                ans.setCharAt(marka, b);
                ans.setCharAt(markb, a);
                a = '@';
                b = '@';
            }
            if ( a == '@') i++;
            if ( b == '@') j--;
        }
        return ans.toString();
    }
}