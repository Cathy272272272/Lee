class 592FractionAdditionandSubtraction {
    public String fractionAddition(String expression) {
        int n = expression.length(), i = 0, j;
        List<Integer> list = new ArrayList<Integer>();
        if ( expression.charAt(i) == '-' ) {
            j = i + 2;
            while ( expression.charAt(j) != '/' ) j++;
            list.add(-Integer.parseInt(expression.substring(i+1, j)));
            i = ++j;
            //j++;
            while ( expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                j++;
                if ( j == n ) break;
            }
            list.add(Integer.parseInt(expression.substring(i,j)));
        }
        else {
            j = i + 1;
            while ( expression.charAt(j) != '/' ) j++;
            list.add(Integer.parseInt(expression.substring(i, j)));
            i = ++j;
            //j++;
            while ( expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                j++;
                if ( j == n ) break;
            }
            list.add(Integer.parseInt(expression.substring(i,j)));
        }
        while ( i < n ) {
            if (expression.charAt(i) == '/' ) {
                j = i - 2;
                while ( expression.charAt(j) != '+' && expression.charAt(j) != '-') j--;
                if ( expression.charAt(j) == '-' ) {
                    list.add(-Integer.parseInt(expression.substring(j+1, i)));
                }
                else {
                    list.add(Integer.parseInt(expression.substring(j+1, i)));                 
                }
                j = i + 1;
                while ( expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                    j++;
                    if ( j == n ) break;
                }
                    list.add(Integer.parseInt(expression.substring(++i, j)));
                i = j + 2;
            }
            else i++;
        }
        int size = list.size(), scm = 1, tmp, gcd, numerator = 0;
        for ( i = 1; i < size; i+= 2) {
            tmp = (int)Math.abs(list.get(i));
            if ( scm % tmp != 0 ) {
                if ( scm > tmp ) gcd = gcd(scm, tmp);
                else gcd = gcd(tmp, scm);
                scm*= tmp/gcd;
            }
        }
        for (  i = 0; i < size; i += 2 ) {
            numerator += list.get(i)*scm/list.get(i+1);
        }
        int absnum = (int)Math.abs(numerator);
        if ( absnum > scm ) gcd = gcd(absnum, scm);
        else gcd = gcd(scm, absnum);
        StringBuilder res = new StringBuilder();
        if ( numerator < 0 ) res.append('-');
        res.append(absnum/gcd).append('/').append(scm/gcd);
        return res.toString();
    }
    public int gcd ( int a, int b ) {
        if ( b == 0 ) return a;  
        if ( a % b != 0 ) return gcd ( b, a % b);
        return b;
    }
}