class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String table[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        int count = 1;
        String transform[] = new String[words.length];
        boolean check[] = new boolean[words.length];
        //if(words != null && !(words.length > 0)) // check null and empty conditions
            if ( words.length <= 100 ){ //check 1st condition
                if (words.length == 0 )
                    return 0; // Must consider the case []!!!!!!!!!
                else{
                for ( int i = 0; i < words.length; i++ )
                    if ( words[i].length() <= 12 && words[i].length() >= 1) //check 2nd condition
                        for ( int j = 0; j < words[i].length(); j++ )
                            if ( words[i].substring(j, j + 1 ).compareTo("z") <= 0 && words[i].substring(j, j + 1 ).compareTo("a") >= 0 ) // check 3rd condition
                                transform[i] += table[words[i].substring(j, j + 1).compareTo("a")]; // when adding, words[i] always begins with null
            }
            }
                           
        for ( int i = 1; i < words.length; i++ ){
            count++; // assume transform[i] is different
            for ( int j = 0; j < i; j++ )//only compares to different transformations
                if ( transform[i].equals(transform[j])){
                    count--; // deny the assumption
                    break;
                }
        }
            
                    
                    
        return count;                     
    }
}