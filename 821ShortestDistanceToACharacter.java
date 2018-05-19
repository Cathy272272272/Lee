class 821ShortestDistanceToACharacter{
    public int[] shortestToChar(String S, char C) {
        int array[] = new int[S.length()];
        int distance = 0;
        if ( S.length() >= 1 && S.length() <= 10000 ){
            for ( int i = 0; i < S.length(); i++ ){
                distance = 0;
                        while ( ! ( S.charAt((i + distance) <= (S.length() - 1) ? (i + distance) : (S.length() - 1) )== C || S.charAt((i - distance) >= 0 ? (i - distance) : 0 )== C ))
                            distance++;
                array[i] = distance;
            }
        }
        return array;
    }
}