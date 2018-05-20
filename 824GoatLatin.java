/*
 * class Solution {
    public static final Character[] vowelsList = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    public static final HashSet<Character> vowels = new HashSet<Character>(Arrays.asList(vowelsList));
    
    public String toGoatLatin(String S) {
        if(S == null || S.length() == 0) {
            return "";
        }
        StringBuilder answer = new StringBuilder();
        int wordIndex = 1;
        
        for (String word : S.split(" ")) {
            if (wordIndex != 1) {
                answer.append(" ");
            }
            char firstCharacter = word.charAt(0);
            if (vowels.contains(firstCharacter)) {
                answer.append(word);
            } else {
                answer.append(word.substring(1));
                answer.append(firstCharacter);
            }
            answer.append("ma");
            for (int i = 0; i < wordIndex; i++) {
                answer.append("a");
            }
            wordIndex++;
        }
        
        return answer.toString();
    }
}
Time Complexity Explanation
Assume, length of the given string is N and it has K words. Thus, average characters per word will be L = N/K including the space. Time complexity of each for-loop iteration:

chartAt[0] is O(1)
HashSet lookup is O(1)
If first character is a vowel, then O(L-1) to append to StringBuilder. (-1 for the space)
If first character is not a vowel, then
a. O(L-1) to find the substring
b. O(L-2) to append the substring
c. O(1) to append the first character
O(2) to append "ma"
O(K) to append "a"
Total for each for loop iteration = O(L+K). The for-loop executes K times, once for each word. Thus, the time complexity is O(K*(L+K)) = O(N + K^2).
Worst Case: Each word is of length 1 and number of words = N/2. The worst case complexity will be O(N^2).

Space Complexity Explanation
Assume, length of the given string is N and it has K words.
Length of the word at index iwill be increased by i+2 characters. Thus, there will be 3 + 4 + 5 .... + (K+2) new characters in the final string. Length of the final string = N + 3 + 4 + 5 + .... + (K+2) = N + 2K + 1 + 2 + 3 + .... + K = N + 2K + K(K+1)/2. Thus, the space complexity is O(N + K^2).
Worst Case: Each word is of length 1 and number of words = N/2. The worst case complexity will be O(N^2).
*/
class 824GoatLatin{
    public String toGoatLatin(String S) {
        StringBuilder out = new StringBuilder();
        String[] array = S.split("\\s+"); // split by space
        if ( S.length() >= 1 && S.length() <= 150 ){
            for ( int i = 0; i < array.length; i++ ){ 
                if ( array[i].charAt(0) == 'a' || array[i].charAt(0) == 'o' || array[i].charAt(0) == 'e' || array[i].charAt(0) == 'i' || array[i].charAt(0) == 'u' || array[i].charAt(0) == 'A' || array[i].charAt(0) == 'O' || array[i].charAt(0) == 'E' || array[i].charAt(0) == 'I' || array[i].charAt(0) == 'U' )
                    out.append(array[i]);
                else
                    out.append(array[i].substring(1)).append(array[i].charAt(0));
                out.append("ma");
                for ( int j = 0; j < i + 1; j++ )
                    out.append("a");
                if ( i != array.length - 1 )
                    out.append(" ");
            }
        }
        return out.toString();
    }
}