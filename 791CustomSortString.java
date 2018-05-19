/*
 *     public String customSortString(String S, String T) {
        int[] count = new int[26];
        for (char c : T.toCharArray()) { ++count[c - 'a']; }  // count each char in T.
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {                            
            while (count[c - 'a']-- > 0) { sb.append(c); }    // sort chars both in T and S by the order of S.
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) { sb.append(c); }   // group chars in T but not in S.
        }
        return sb.toString();
   }
   */
class 791CustomSortString{
    public String customSortString(String S, String T) {
        int a[] = new int[S.length()];//gtouping the characters in T wrt order in S
        StringBuilder other = new StringBuilder();//to store other characters in T but not in S
        boolean check = false; //check whether characters are in S or not
        if ( S.length() <= 26 && S.length() >= 0 && T.length() <= 200 && T.length() >= 0 ){
            for ( int i = 0; i < T.length(); i++ ){
                for ( int j = 0; j < S.length(); j++ ){
                    check = false;
                    if ( T.charAt(i) == S.charAt(j)){
                        a[j]++;
                        check = true;
                        break;
                    }                        
                }
                if ( !check )
                    other.append(T.charAt(i));
            }
            for ( int i = 0; i < S.length(); i++ )
                for ( int j = 0; j < a[i]; j++ )
                    other.append(S.charAt(i));
                
        }
        return other.toString();
            
    }
}