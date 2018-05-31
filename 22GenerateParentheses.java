/* clever......
 *  public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
    */
class 22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if ( n == 1 ) {
            list.add("()");
            return list;
        }
        StringBuilder temp1, temp2, temp3;
        String s1, s2, s3, t1, t2, t3;
        s1 = "";
        t1 = "";
        for ( String i : generateParenthesis(n - 1 ) ) {
            temp1 = new StringBuilder(i);
            s1 = temp1.insert(0,'(').append(')').toString();
            list.add(s1);
        }
        for ( int k = 1; k < n/2 + 1; k++ ) {
            for ( String i : generateParenthesis(n - k ) ) {
                temp1 = new StringBuilder(i);
                s1 = temp1.toString();
                for ( String j : generateParenthesis( k ) ) {
                    temp2 = new StringBuilder(j);
                    t1 = temp2.toString();
                    if ( !list.contains(s1 + t1) ) list.add(s1 + t1);
                    if ( !list.contains(t1 + s1) ) list.add(t1 + s1);
                }
            }
        }
        return list;
        }
    }