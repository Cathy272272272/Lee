class 171ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int count = 0;
        for ( int i = s.length() - 1; i >= 0; i-- ) 
            count += Math.pow(26, (s.length() - 1 - i )) * ( 1 + s.charAt(i) - 'A' ); 
        return count;
    }
}