/*
 * class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String target = licensePlate.toLowerCase();
        int [] charMap = new int[26];
        // Construct the character map
        for(int i = 0 ; i < target.length(); i++){
            if(Character.isLetter(target.charAt(i))) charMap[target.charAt(i) - 'a']++;
        }
        int minLength = Integer.MAX_VALUE;
        String result = null;
        for (int i = 0; i < words.length; i++){
            String word = words[i].toLowerCase();
            if(matches(word, charMap) && word.length() < minLength) {
                minLength = word.length();
                result  = words[i];
            }
        }
        return result;
    }
    private boolean matches(String word, int[] charMap){
        int [] targetMap = new int[26];
        for(int i = 0; i < word.length(); i++){
            if(Character.isLetter(word.charAt(i))) targetMap[word.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(charMap[i]!=0 && targetMap[i]<charMap[i]) return false;
        }
        return true;
    }
}
*/
class 748ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
    StringBuilder s = new StringBuilder();
    for ( int i = 0; i < licensePlate.length(); i++ ){
        if ((licensePlate.charAt(i) >= 'a' && licensePlate.charAt(i) <= 'z') || (licensePlate.charAt(i) >= 'A' && licensePlate.charAt(i) <= 'Z')){
            s.append(licensePlate.charAt(i));
        }
    }
    StringBuilder temp1, temp2;
    String result = "";
    int count,min, i, j, k;
    boolean visited = false;
    min = 0;
        i = 0;
        j = 0;
        k = 0;
    for ( i = 0; i < words.length; i++ ){
        temp1 = new StringBuilder(s);
        temp2 = new StringBuilder(words[i]);
        count = s.length();
        for ( j = 0; j < temp1.length(); j++ ){
            for ( k = 0; k < temp2.length(); k++ ){
                if ( temp1.charAt(j) == temp2.charAt(k) || temp1.charAt(j) == temp2.charAt(k) + 'A' - 'a' || temp1.charAt(j) == temp2.charAt(k) -'a' + 'A' ){
                    temp1.deleteCharAt(j);
                    temp2.deleteCharAt(k);
                    count--;
                    j = -1;
                    k = 0;
                    break;
                }
            }
            if ( count == 0 ) {
                if ( !visited ) {
                    min = words[i].length();
                    result = words[i];
                    visited = true;
                }
                else
                    if ( min > words[i].length() ){
                    min = words[i].length();
                    result = words[i];
                    System.out.println(min + " " + result);
                    }
            }
            if ( k == temp2.length()) break;
        }
    }
        return result;
    }
}