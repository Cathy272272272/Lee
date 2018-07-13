class 17LetterCombinationsofaPhoneNumber {
    Map<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
    //List<String> list = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if ( n == 0 ) return new ArrayList<String>();
        put();
        return help(digits);
        //return list;
    }
    public List<String> help(String digits) {
        int n = digits.length();
        if ( n == 0 ) return new ArrayList<String>();
        List<Character> c = map.get(digits.charAt(0) - '0');
        StringBuilder s = new StringBuilder();
        List<String> list = new ArrayList<String>();
        for ( Character i : c ) {
            s = new StringBuilder();
            s.append(i);
            List<String> l = help(digits.substring(1));
            if ( l.size() != 0 ) {
                for ( String j : l ) {
                    s.append(j);
                    String tmp = s.toString();
                    /*if ( !list.contains(tmp) ) */list.add(tmp);
                    s.delete(1, s.length());
                }
            }
            else list.add(s.toString());
            s.delete(0,1);
        }
        return list;
    }
    public void put() {
        List<Character> tmp;
        int a = 'a';
        for ( int i = 2; i < 10; i++ ) {
            tmp = new ArrayList<Character>();
            if ( i <= 7 ) {
                tmp.add((char)((i-2)*3 + a));
                tmp.add((char)((i-2)*3 + 1 + a));
                tmp.add((char)((i-2)*3 + 2 + a));
                if ( i == 7 ) tmp.add((char)((i-2)*3 + 3 + a));
            }
            else {
                tmp.add((char)((i-2)*3 + 1 + a));
                tmp.add((char)((i-2)*3 + 2 + a));
                tmp.add((char)((i-2)*3 + 3 + a));
                if ( i == 9 ) tmp.add((char)((i-2)*3 + 4 + a));
            }
            map.put(i, tmp);
        }
    }
}