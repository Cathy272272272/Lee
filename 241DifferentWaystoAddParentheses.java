/*
 * public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                input.charAt(i) == '*' ||
                input.charAt(i) == '+' ) {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 :   part1Ret) {
                    for (Integer p2 :   part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;
                                break;
                            case '-': c = p1-p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }
}
*/
class 241DifferentWaystoAddParentheses {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> diffWaysToCompute(String input) {
        int n = input.length();
        List<Integer> num = new ArrayList<Integer>();
        List<String> op = new ArrayList<String>();
        int prev = 0;
        for ( int i = 0; i < n; i++ ) {
            char s = input.charAt(i);
            if ( s == '*' || s == '+' || s == '-' ) {
                num.add(Integer.parseInt(input.substring(prev, i)));
                op.add(input.substring(i, i+1));
                prev = i + 1;
            }
        }
        num.add(Integer.parseInt(input.substring(prev, n)));
        return add(num, op);
    }
    public int ops( int a, int b, char c) {
        if ( c == '*') return a * b;
        else if ( c == '+' ) return a + b;
        else return a - b;
    }
    public int result(List<Integer> num, List<String> op) {
        if ( num.size() == 1 ) return num.get(0);
        return ops(num.get(0), result(num.subList(1,num.size()),op.subList(1,op.size())), op.get(0).charAt(0) );
    }
    public List<Integer> add(List<Integer> num, List<String> op) {
        List<Integer> tmp = new ArrayList<Integer>();
        if ( num.size() == 1 ) {
            tmp.add(num.get(0));
            return tmp;
        }
        int size = 1;
        int n = num.size();
        while ( size <= n / 2 ) {
            for ( int i : add(num.subList(0, size), op.subList(0, size - 1))) {
                for ( int j : add(num.subList(size, num.size()), op.subList(size, op.size()))) {
                    tmp.add(ops(i,j,op.get(size - 1).charAt(0) ));
                }
            }
            int antisize = n - size;
            if ( antisize == size ) {
                size++;
                continue;
            }
            for ( int i : add(num.subList(0, antisize), op.subList(0, antisize - 1))) {
                for ( int j : add(num.subList(antisize, num.size()), op.subList(antisize, op.size()))) {
                    tmp.add(ops(i,j,op.get(antisize - 1).charAt(0) ));
                }
            }
            size++;
        }
        return tmp;
    }
}