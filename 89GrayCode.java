class 89GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        if ( n == 0 ) return list;
        list.add(1);
        int mark = 1, tmp;
        for ( int i = 2; i <= n; i++ ) {
            tmp = (int)Math.pow(2, i-1);
            for ( int j = tmp - 1; j >= 0; j-- ) 
                list.add(list.get(j) + tmp );
        }
        return list;
    }
}