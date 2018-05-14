class 771JewelsAndStones {
    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        for ( int i = 0; i < S.length(); i++ ){
            for ( int j = 0; j < J.length(); j++ ){
                if ( S.substring(i, i + 1).equals( J.substring(j, j + 1))){
                    count++;
                    break;
                }
            }
        }
        return count;
        
    }
    public static void main(String[] args) {         
        String J = args[0];
        String S = args[1];
        int numJewelsInStones = numJewelsInStones( J, S );
        System.out.println( numJewelsInStones);
    }
}
