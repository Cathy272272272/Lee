/*
 * /*
Basic idea: each time we take a look at the last four digits of
            binary verion of the input, and maps that to a hex char
            shift the input to the right by 4 bits, do it again
            until input becomes 0.



public class Solution {
    
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public String toHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result; 
            num = (num >>> 4);
        }
        return result;
    }
    
    
}````
    */
    class 405ConvertaNumbertoHexadecimal {
    public String toHex(int num) {
        if ( num == 0 ) return "0";
        StringBuilder ans = new StringBuilder();
        char[] c = new char[]{'a','b','c','d','e','f'};
        int tmp;
        long help = (long)num;
        if ( help < 0 ) {
            help += (long)Math.pow(2, 32);
        }
        while ( help > 0 ) {
            tmp = (int)help%16;
            if ( tmp < 0 ) {
                tmp += 16;
            }
            if ( tmp < 10 ) ans.append(tmp);                
            else ans.append(c[tmp-10]);
            help/=16;
        }
        return ans.reverse().toString();
    }
}