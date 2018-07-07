class 119PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        return add(0, rowIndex, new ArrayList<Integer>());
    }
    public List<Integer> add(int row, int max, List<Integer> list) {
        if ( row > max ) return list;
        if ( row == 0 ) {
            list.add(1);
            return add(row+1, max, list);
        }
        if ( row == 1 ) {
            list.add(1);
            return add(row+1, max, list);
        }
        for ( int i = 1; i < row; i++ ) {
            list.add(list.get(0) + list.get(1));
            list.remove(0);
        }
        list.add(1);
        return add(row+1, max, list);
    }
}