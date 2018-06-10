class 638ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int items = price.size(), offers = special.size(), count = 0;
        if ( items > 6 || offers > 100 || items == 0 || items != needs.size()) return 0;
        List<Integer> help = new ArrayList<Integer>();
        boolean valid;
        int tmp, max = 0, a, b;
        for ( int i = 0; i < items; i++ ) {
            max += price.get(i) * needs.get(i);
        }
        tmp = max;
        for ( List<Integer> i : special ) {
            valid = true;
            help.clear();
            for ( int j = 0; j < items; j++ ) {
                int s = i.get(j), n = needs.get(j);
                if ( s > n ) {
                    valid = false;
                    break;
                }
                help.add(n - s);
            }
            if ( valid ) tmp = i.get(items) + shoppingOffers(price, special, help);
            if ( tmp < max ) max = tmp;
        }
        return max;
        
    }
}