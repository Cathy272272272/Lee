class 649Dota2Senate {
    public String predictPartyVictory(String senate) {
        int n = senate.length(), meetR = 0, meetD = 0, dieR = 0, dieD = 0;
        StringBuilder help = new StringBuilder();
        while (true ) {
            for ( char i : senate.toCharArray() ) {
                if ( i == 'R' ) {
                    if ( meetR >= dieR ) help.append(i);
                    meetR++;
                    dieD++;
                }     
                else {
                    if ( meetD >= dieD ) help.append(i);
                    meetD++;
                    dieR++;
                }
            }
            senate = help.toString();
            help.delete(0, help.length());
            if (  !senate.contains("D") ) return "Radiant";
            else if ( !senate.contains("R") ) return "Dire";
        }
    }
}