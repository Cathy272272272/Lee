class 765CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int count = 0;
        int temp, j;
        for ( int i = 0; i < row.length; i += 2 ) { 
            if ( row[i] % 2 == 0 ) {
                if (row[i+1] - row[i] != 1 ) 
                    for ( j = i + 1 ; j < row.length; j++ ) 
                        if ( row[j] -row[i] == 1 ) {
                            temp = row[i + 1];
                            row[i + 1] = row[j];
                            row[j] = temp;
                            count++;
                            break;
                        }
            }
            else {
                if (row[i] - row[i + 1] != 1) 
                    for ( j = i + 1 ; j < row.length; j++ ) 
                        if ( row[j] -row[i] == -1 ) {
                            temp = row[i + 1];
                            row[i + 1] = row[j];
                            row[j] = temp;
                            count++;
                            break;
                        }
            }
        }
        return count;
    }
}