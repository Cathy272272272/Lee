/**
 * break & continue!!!
 */
class  500KeyboardRow{
    public String[] findWords(String[] words) {
        String[] out = new String[words.length];
        char[][] keyboard = {{'q','w','e','r','t','y','u','i','o','p'},{'a','s','d','f','g','h','j','k','l'},{'z','x','c','v','b','n','m'}};
        int mark = 0;
        int count = 0;
        boolean temp = false;
        for ( int i = 0; i < words.length; i++ ){
            if ( words[i].length() == 1 ){
                out[count] = words[i];
                count++;
            }
            else{
                for ( int j = 0; j < keyboard.length; j++ )
                for ( int k = 0; k < keyboard[j].length; k++ )
                    if ( (words[i].charAt(0) == keyboard[j][k]) || (Character.toLowerCase( words[i].charAt(0))) == keyboard[j][k])
                        mark = j; // find the row

            for ( int j = 1; j < words[i].length(); j++ ){
                temp = false;
                for ( int k = 0; k < keyboard[mark].length; k++ )
                    if ( words[i].charAt(j) == keyboard[mark][k] || (Character.toLowerCase( words[i].charAt(j))) == keyboard[mark][k] ){
                        temp = true;
                        break;
                    }
                if ( !temp ) // the word should not be in the out
                    break;
            }
                if ( temp ){
                out[count] = words[i];
                count++;
                }
        }
    }
        String ans[] = new String[count];
        for ( int i = 0; i < count; i++ )
            ans[i] = out[i];
        return ans;
            
    }
}