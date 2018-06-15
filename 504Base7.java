class 504Base7 {
    public String convertToBase7(int num) {
        if ( num == 0 ) return "0";
        StringBuilder s = new StringBuilder();
        boolean check = false;
        if ( num < 0 ) {
            num = -num;
            check = true;
        }
        while ( num > 0 ) {
            s.append( num % 7);
            num /= 7;
        }
        if ( check ) s.append("-");
        return s.reverse().toString();
    }
}