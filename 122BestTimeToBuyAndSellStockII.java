class 122BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int length = prices.length;
        int count;
        boolean check;
        Search:
        for ( int i = 1; i < length; i++ ) {
            check = false;
            while ( prices[i] > prices[i - 1] ) {
                if (!check )
                    profit -= prices[i - 1];
                check = true;
                if ( i == length - 1 ) {
                    profit += prices[i];
                    break Search;
                }
                i++;
            }
            if ( check ) {
                 profit += prices[i - 1];
            }
        }
        return profit;
    }
}