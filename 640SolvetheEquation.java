class 640SolvetheEquation {
    public String solveEquation(String equation) {
        String[] s = equation.split("=");
        int[] left = help(s[0]);
        int[] right = help(s[1]);
        System.out.println(left[0] + " " + left[1] + " " + right[0] + " " + right[1]);
        if ( left[0] == right[0] ) {
            if ( left[1] == right[1] ) return "Infinite solutions";
            else return "No solution";
        }
        int ans = (right[1] - left[1]) / (left[0] - right[0]);
        return "x=" + String.valueOf(ans);
    }
    public int[] help(String s) {
        int l = s.length();
        if ( l == 0 ) return new int[2];
        int prev = -1;
        boolean plus = true;
        int c = 0, x = 0;
        for ( int i = 0; i < l; i++ ) {
            if ( s.charAt(i) == '+' ) {
                if ( s.substring(prev + 1, i).indexOf('x') == -1 ) {
                    if (plus) c += Integer.parseInt(s.substring(prev + 1, i));
                    else c -= Integer.parseInt(s.substring(prev + 1, i));
                }
                else {
                    if (plus) {
                        if ( s.substring(prev + 1, i - 1).length() == 0 ) x++;
                        else x += Integer.parseInt(s.substring(prev + 1, i - 1));
                    }
                    else {
                        if ( s.substring(prev + 1, i - 1).length() == 0 ) x--;
                        else x -= Integer.parseInt(s.substring(prev + 1, i - 1));                    
                    }                   
                }
                plus = true;
                prev = i;
            }
            else if ( s.charAt(i) == '-' ) {
                if ( i == 0 ) {
                    plus = false;
                    prev = i;
                    continue;
                }
                if ( s.substring(prev + 1, i).indexOf('x') == -1 ) {
                    if (plus) c += Integer.parseInt(s.substring(prev + 1, i));
                    else c -= Integer.parseInt(s.substring(prev + 1, i));
                }
                else {
                    if (plus) {
                        if ( s.substring(prev + 1, i - 1).length() == 0 ) x++;
                        else x += Integer.parseInt(s.substring(prev + 1, i - 1));
                    }
                    else {
                        if ( s.substring(prev + 1, i - 1).length() == 0 ) x--;
                        else x -= Integer.parseInt(s.substring(prev + 1, i - 1));                    
                    }                    
                }
                plus = false;
                prev = i;
            }
        }
        if ( s.substring(prev + 1).indexOf('x') == -1 ) {
            if (plus) c += Integer.parseInt(s.substring(prev + 1));
            else c -= Integer.parseInt(s.substring(prev + 1));
        }
        else {
            if (plus) {
                if ( s.substring(prev + 1, l - 1).length() == 0 ) x++;
                else x += Integer.parseInt(s.substring(prev + 1, l - 1));
            }
            else {
                if ( s.substring(prev + 1, l - 1).length() == 0 ) x--;
                else x -= Integer.parseInt(s.substring(prev + 1, l - 1));                    
                }                    
        }
        int[] ans = new int[]{x, c};
        return ans;
    }
}