//dont think it is hard, but very fan ren......
class 726NumberofAtoms {
    Map<String, Integer> map = new TreeMap<String, Integer>();
    public String countOfAtoms(String formula) {
        int n = formula.length();
        help(formula, 1);
        System.out.println(map);
        StringBuilder tmp = new StringBuilder();
        for ( String k : map.keySet()) {
            tmp.append(k);
            if (map.get(k) != 1) tmp.append(map.get(k));
        }

        return tmp.toString();
    }
    public void help(String s, int m) {
        int n = s.length();
        int start = 0, end = -1, count = 0, i, j;
        boolean ss = false, ee = false;
        for ( i = 0; i < n; i++) {
            if (s.charAt(i) == '(' ) {
                if ( !ss ) {
                    start = i;
                    ss = true;
                    if ( start != 0 ) {
                        end++;
                        while ( end < start ) {
                            if (s.charAt(end) - '0' >= 0 && s.charAt(end) - '0' <= 9 ) end++;
                            else break;
                        }
                        if ( end != start ) {
                            System.out.println(s.substring(end, start));
                            add(s.substring(end, start), m);
                        }
                    }
                }
                count++;
            }
            if (s.charAt(i) == ')') {
                end = i;
                count--;
            }
            if( count == 0 && ss ) {
                int tmp = 1;
                while ( s.charAt(end + tmp) - '0' >= 0 && s.charAt(end + tmp) - '0' <= 9  ) {
                    tmp++;
                    if ( end + tmp > n - 1) break;
                }
                if(tmp == 1 ) help(s.substring(start+1, end),  m);
                help(s.substring(start+1, end), Integer.parseInt(s.substring(end+1, end + tmp)) * m);
                ss = false;
            }
        }
            end++;
            while ( end < n ) {
                if (s.charAt(end) - '0' >= 0 && s.charAt(end) - '0' <= 9 ) end++;
                else break;
            }
            if ( end != n ) 
            add(s.substring(end), m);
    }
    public void add(String s, int m) {
            int n = s.length();
            int mark = 0;
            boolean b1 = false, b2 = false;
            String tmp = "";
            int i = 0;
            while ( i < n) {
                if ( s.charAt(i) - 'A' >= 0 && s.charAt(i) - 'A' <= 26 && !b1) {
                    //mark1 = i;
                    if ( i < n - 1) {
                        if ( s.charAt(i + 1) - 'a' >= 0 && s.charAt(i + 1) - 'a' <= 26 ) {
                            tmp = s.substring(i, i+2);
                            i += 2;
                            mark = i;
                        }
                        else { tmp = s.substring(i, i+1); i++; mark = i; }
                    }
                    else { tmp = s.substring(i); i++;
                         }
                    b1 = true;
                }
                else if ( b1 && (s.charAt(i) - '0' < 0 || s.charAt(i) - '0' > 9) ) {
                    int multiple;
                    if ( i == mark ) multiple = 1;
                    else multiple = Integer.parseInt(s.substring(mark, i));
                    map.put(tmp, (Integer)map.getOrDefault(tmp, 0) + multiple * m);
                    b1 = false;
                }
                else i++;
            }
            if (!b1) tmp = s.substring(n-1);
            if ( s.charAt(n-1) - '0' < 0 || s.charAt(n-1) - '0' > 9 )                     
                map.put(tmp, (Integer)map.getOrDefault(tmp, 0) +  m);
            else map.put(tmp, (Integer)map.getOrDefault(tmp, 0) + Integer.parseInt(s.substring(mark)) * m);    
    }
}