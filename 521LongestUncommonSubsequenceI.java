/*
 * the question is stupid......
 */
 class 521LongestUncommonSubsequenceI{
    public int findLUSlength(String a, String b) {
        if ( a.length() <= 100 && b.length() <= 100 ){
            if ( a.equals(b) )
                return -1;
            else
                return Math.max (a.length(), b.length());
        }
        return -1;
}
}