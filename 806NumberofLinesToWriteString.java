class 806NumberofLinesToWriteString{
    public int[] numberOfLines(int[] widths, String S) {
        boolean check = true;
        int sumcheck = 0;
        int lines = 1;
        int mark;
        if ( S.length() >= 1 && S.length() <= 1000 && widths.length == 26 ){
            for ( int i = 0; i < widths.length; i++ ) //check the length of widths[i]
                if ( widths[i] > 10 || widths[i] < 2 ){
                    check = false;
                    break;
                }
        for ( int i = 0; i < S.length(); i++ ){
            mark =  S.substring(i, i + 1).compareTo("a");
            if ( mark >= 0 && mark <= 26 ){            
                if ( (sumcheck + widths[mark]) > 100 ){
                    sumcheck = widths[mark];
                    lines++;
                }
                else{
                    sumcheck += widths[mark];
                }
            }
        }
        }
        int[] answer = { lines, sumcheck };
        return answer;
    }
}