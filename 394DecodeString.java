/*public class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
*/
class Solution {
    public String decodeString(String s) {
        int n = s.length();
        if ( n == 0 ) return "";
        char tmp;
        StringBuilder help = new StringBuilder();
        int left = 0, mark1 =0, mark2 = -1, mark3 = 0, mark4 = 0, mark = 0, times;
        boolean num = false, abc = false, find = false, three = false, four = false, two = false, one = false, add = false, ffind = false;
        for ( int i = 0; i < n; i++ ) {
            tmp = s.charAt(i);
            if ( tmp == '[' ) {
                find = true;
                ffind = true;
                if ( !add && two && three ) {
                    if ( mark2 < mark3 )
                    help.append(s.substring(mark2, mark3));
                    add = true;
                }
                left++;
                if ( left == 1 ) mark1 = i;
            }
            if ( tmp == ']' ) {
                left--;
                mark = i;
            }
            if ( left == 0 && ffind ) {
                if ( mark4 != mark3 )
                    times = Integer.parseInt(s.substring(mark3, mark4));
                else times = 1;
                for ( int j = 0; j < times; j++ )
                    help.append(decodeString(s.substring(mark1+1, i)));
                mark1 = i; mark2 = i - 1; mark3 = i; mark4 = i;
                num = false; abc = false; three = false; four = false; two = false; one = false; add = false;ffind = false;
            }
            if ( !three && !num && ( tmp - '0' <= 9 && tmp - '0' >= 0 )) {
                mark3 = i;
                three = true;
            }
            if ( !four && num && ( tmp - '0' > 9 || tmp - '0' < 0 )) {
                mark4 = i;
                four = true;
            }
            if ( !two && !abc && ((tmp - 'a' >= 0 && tmp - 'a' <= 26) || (tmp - 'A' >= 0 && tmp - 'A' <= 26))) { 
                two = true; 
                mark2 = i;
            }
            if ( !three || !four){
                if (  (tmp - '0' > 9 || tmp - '0' < 0) ) num = false;
                else num = true;
            }
            if (!two) {
                if ( (tmp - 'a' >= 0 && tmp - 'a' <= 26) || (tmp - 'A' >= 0 && tmp - 'A' <= 26)) abc = true;
                else abc = false;
            }
        }
        if(mark != n - 1) help.append(s.substring(mark + 1));
        if ( !find ) return s;
        else return help.toString();
    }
}
