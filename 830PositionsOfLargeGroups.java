class 830PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp;
        int length = S.length();
        char s;
        int count, j;
        for ( int i = 0; i < length - 1; i++ ) {
            s = S.charAt(i);
            count = 1;
            for ( j = i + 1; j < length; j++ ) {
                if ( s == S.charAt(j) )
                    count++;
                else break;
            }
            j--;
            if ( count >= 3 ) {
                temp = new ArrayList<Integer>();
                temp.add(i);
                temp.add(j);
                res.add(temp);
            }
            i = j;
        }
        return res;
    }
}