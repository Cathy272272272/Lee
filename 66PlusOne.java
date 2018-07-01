/*
 * public int[] plusOne(int[] digits) {
        
    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        
        digits[i] = 0;
    }
    
    int[] newNumber = new int [n+1];
    newNumber[0] = 1;
    
    return newNumber;
}
*/
class 66PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if (digits[n-1] == 9 ) {
            //int[] ans = new int[n+1];
           if ( n == 1 ) return new int[]{1, 0};
           if ( digits[0] == 9 ) {
            digits = plusOne(Arrays.copyOfRange(digits, 0, n-1));
            int[] ans = new int[n+1];
            for ( int i = 0; i < n; i++ ) ans[i] = digits[i];
            return ans;
           }
           int[] tmp = new int[n-1];
           tmp = plusOne(Arrays.copyOfRange(digits, 0, n-1));
           for ( int i = 0; i < n - 1; i++ ) digits[i] = tmp[i];
           digits[n-1] = 0;
           return digits;
        } 
        digits[n-1]++;
        return digits;
    }
}