/*
 * Stupid question, stupid me!!!!!!!!!
 * class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
*/
class 796RotateString {
    public boolean rotateString(String A, String B) {
        if ( A.length() == 0 && B.length() == 0 ) return true;
        if ( A.length() == 0 || B.length() == 0 ) return false;
        if ( A.length() != B.length() ) return false;
        StringBuilder tempA = new StringBuilder(A);
        int length = B.length();
        int temp = 0;
        int index = 0;
        int count = 0;
        String help;
        do{
            if ( count == length ) break;
            count++;
            if ( tempA.charAt(0) == A.charAt(0) ){
                temp = length - B.substring(0, length - index).lastIndexOf(tempA.charAt(0), length);
            }
            else
                temp = length - B.lastIndexOf(tempA.charAt(0), length);
            if ( temp == index || temp == length + 1) return false;
            index = temp;

            tempA.append(tempA.substring(0, index)).delete(0, index);
            help = tempA.toString();
            if ( help.equals(B) )
                return true;

        }while ( !help.equals(A) );
        return false;
    }
}