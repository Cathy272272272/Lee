/*
 * public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        if (secret.charAt(i) == guess.charAt(i)) bulls++;
        else {
            if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
            if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
        }
    }
    return bulls + "A" + cows + "B";
}
*/
class 299BullsandCows {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int b = 0, c = 0;
        List<Character> list = new ArrayList<>();
        for ( char i : secret.toCharArray()) list.add(i);
        for ( int i = 0; i < n; i++ ) {
            if (guess.charAt(i) == secret.charAt(i)) {
                int idx = list.indexOf(guess.charAt(i));
                if ( idx != -1 ) list.remove(idx);
                else c--;
                b++;
            }
            else if ( list.contains(guess.charAt(i))) {
                c++;
                int idx = list.indexOf(guess.charAt(i));
                list.remove(idx);
            }
        }
        return b + "A" + c + "B";
    }
}