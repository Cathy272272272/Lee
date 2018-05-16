class 657JudgeRouteCircle{
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for ( int i = 0; i < moves.length(); i++ ){
            if (moves.substring(i,i+1).equals("R"))
                x++;
            else if (moves.substring(i,i+1).equals("L"))
                x--;
            else if (moves.substring(i,i+1).equals("U"))
                y++;
            else if (moves.substring(i,i+1).equals("D"))
                y--;
        }
        if ( x== 0 && y == 0 )
            return true;
        else
            return false;
    }
}