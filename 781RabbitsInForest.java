class 781RabbitsInForest {
    public int numRabbits(int[] answers) {
        if ( answers.length > 1000 || answers.length < 1 ) return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for ( int i = 0; i < answers.length; i++ ) {
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1 );
        }
        System.out.println(map);
        for ( int i : map.keySet() ) 
            count += (map.get(i) + i) / ( i + 1 ) * (i + 1 ); // / ( i + 1 ) * ( i + 1 ) != 1
        return count;
    }
}