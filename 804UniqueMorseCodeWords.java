class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String table[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        int count = 1;
        String transform[] = new String[words.length];
        boolean check[] = new boolean[words.length];
        if ( words.length <= 100 ) //check 1st condition
            for ( int i = 0; i < words.length; i++ )
                if ( words[i].length() <= 12 && words[i].length() >= 1) //check 2nd condition
                   for ( int j = 0; j < words[i].length(); j++ )
                       if ( words[i].substring(j, j + 1 ).compareTo("z") <= 0 && words[i].substring(j, j + 1 ).compareTo("a") >= 0 ){ // check 3rd condition
                        transform[i] += table[words[i].substring(j, j + 1).compareTo("a")]; // when adding, words[i] always begins with null
                        //System.out.println(transform[i]);
                       }
                           
        check[0] = true; // let the 1st word to be counted
        for ( int i = 1; i < words.length; i++ ){
            check[i] = true;
            count++; // assume transform[i] is different
            System.out.print(count);
            for ( int j = 0; j < i && check[j]; j++ ){//only compares to different transformations
                if ( transform[i].equals(transform[j])){
                    check[i] = false; // not compare transform[i] for the rest 
                    count--; // deny the assumption
                    System.out.println(count);
                    break;
                }
                System.out.println("a");
            }
        }
            
                    
                    
        return (count);                     
    }
}