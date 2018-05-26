class 520DetectCapital {
    public boolean detectCapitalUse(String word) {
        if ( word.length() == 0 ) return false;
        if ( word.length() == 1 ) return true;
        boolean capital = false;
        int start;
        if ( word.charAt(0) >= 'A' && word.charAt(0) <= 'Z' && word.charAt(1) >= 'A' && word.charAt(1) <= 'Z' ) capital = true;
        if (!capital) start = 1;
        else start = 2;
        for ( int i = start; i < word.length(); i++ ){
            if ( capital ){
                if ( (word.charAt(i) >= 'a' && word.charAt(i) <= 'z'))
                    return false;
            }
            else {
                if ( (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') )
                return false;
            }
        }
        return true;
    }
}