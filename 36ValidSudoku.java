class 36ValidSudoku {
    public boolean isValidSudoku(char[][] nums) {
        List<Character> r, tmp;
        List<List<Character>> c = new ArrayList<List<Character>>();
        List<List<Character>> b= new ArrayList<List<Character>>();
        for ( int i = 0; i < 9; i++ ) {
            c.add(new ArrayList<Character>());
            b.add(new ArrayList<Character>());            
        }
        int n = nums.length;
        for ( int i = 0; i < n; i++ ) {
            r = new ArrayList<Character>();
            for ( int j = 0; j < n; j++ ) {
                if ( nums[i][j] == '.' ) continue;
                if ( r.contains(nums[i][j] )) {
                    return false;
                }
                r.add(nums[i][j]);
                tmp = c.get(j);
                if ( tmp.contains(nums[i][j])) {
                    return false;
                }
                tmp.add(nums[i][j]);
                tmp = b.get(i/3*3 + j / 3);
                if ( tmp.contains(nums[i][j])) {
                    return false;
                }
                tmp.add(nums[i][j]);                
            }
        }
        return true;
    }
}