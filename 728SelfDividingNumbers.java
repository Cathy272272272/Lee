class 728SelfDividingNumbers{
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> out = new ArrayList<Integer>();
        int temp = 0;
        if ( left >= 1 && right <= 10000 && right >= left ){
            for ( int i = left; i <= right; i++ ){
                temp = check(i);
                if ( temp != 0 ){
                    out.add(temp);
                }
            }
        }
        return out;
    }
    public int check(int i){
        int mark = i;
        while ( i != 0 ){
            if ( i % 10 == 0 )
                return 0;
            else if ( mark % ( i % 10 ) == 0 ){
                i /= 10;
            }
            else 
                return 0;
        }
        return mark;
    }
}