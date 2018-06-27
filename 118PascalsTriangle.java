class 118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if ( numRows == 0 ) return list;
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(1);
        List<Integer> help;
        int size;
        list.add(tmp);
        for ( int i = 1; i < numRows; i++ ) {
            tmp = new ArrayList<Integer>();
            tmp.add(1);
            help = list.get(i-1);
            size = help.size();
            for ( int j = 1; j < size; j++ ) tmp.add(help.get(j-1) + help.get(j));
            tmp.add(1);
            list.add(tmp);
        }
        return list;
    }
}