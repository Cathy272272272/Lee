/* Others solution. the key is sort the array according to length in descending order
 * public class Solution {
    public int maxProduct(String[] words) {
        int max = 0;

        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                return b.length() - a.length();
            }
        });
        int[] masks = new int[words.length]; // alphabet masks

        for(int i = 0; i < masks.length; i++){
            for(char c: words[i].toCharArray()){
                masks[i] |= 1 << (c - 'a');
            }
        }
    
        for(int i = 0; i < masks.length; i++){
            if(words[i].length() * words[i].length() <= max) break; //prunning
            for(int j = i + 1; j < masks.length; j++){
                if((masks[i] & masks[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                    break; //prunning
                }
            }
        }

        return max;
    }
}
*/
class 318MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        int max = 0;
        int n = words.length;
        boolean b;
        List<Character> tmp = new ArrayList<Character>();
        for ( int i = 0; i < n - 1; i++ ) {
            int l = words[i].length();
            for ( int j = 0; j < l; j++ ) {
                char c = words[i].charAt(j);
                if ( !tmp.contains(c) )
                    tmp.add(c);
            }
            for ( int j = i + 1; j < n; j++ ) {
                int len = words[j].length();
                b = false;
                for ( int k = 0; k < len; k++ ) {
                    if ( tmp.contains(words[j].charAt(k)) ) {
                        b = true;
                        break;
                    }
                }
                if ( !b && len*l > max ) max = len * l; 
            }
            tmp.clear();
        }
        return max;
    }
}