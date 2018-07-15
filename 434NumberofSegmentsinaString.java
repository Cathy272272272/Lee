// s.split would count one more times if the string starts with the deliminitor
/*
 * public int countSegments(String s) {
    return ("x " + s).split(" +").length - 1;
}
*/
class 434NumberofSegmentsinaString {
    public int countSegments(String s) {
        int n = s.length();
        if ( n == 0 ) return 0;
        if ( !s.contains(" ")) return 1;
        int i = 0, j = n - 1;
        for ( i = 0; i < n; i++ ) if ( s.charAt(i) != ' ' ) break;
        if ( i == n ) return 0;
        //for ( j = n - 1; j > i; j-- ) if ( s.charAt(j) != ' ' ) break;  
        //if ( i == j ) return 1;
        return s.substring(i, j+1).split("\\s+").length;
    }
}