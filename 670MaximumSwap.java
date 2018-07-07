class 670MaximumSwap {
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        int help = num;
        while( num > 0 ) {
            list.add(num % 10);
            num /= 10;
        }
        int size = list.size();
        if ( size == 0 ) return 0;
        if ( size == 1 ) return list.get(0);
        int max = list.get(size - 1), mark = size - 1;
        while ( true ) {
            for ( int i = size - 2; i >= 0; i-- ) {
                if ( list.get(i) > max ) {
                    mark = i;
                    max = list.get(i);
                } 
                if ( list.get(i) == max && max != list.get(size - 1) ) mark = i;
            }
            if ( mark != size - 1 ) break;
            size--;
            if ( size == 1 ) break;
            max = list.get(size - 1);
            mark = size - 1;
        }
        if ( size == 1 ) return help;
        int tmp = list.get(size - 1);
        list.set(size - 1, list.get(mark));
        list.set(mark, tmp);
        int ans = 0, count = 1;
        for ( int i : list ) {
            ans += count * i;
            count *= 10;
        }
        return ans;
    }
}