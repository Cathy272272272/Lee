/*
 * when using an array inside a loop,
 * since the index of the array may not coincide with the index of the loop,
 * use another count instead!!!!!!!!!
 */
/*
 *class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (String op : ops) {
            if (op.equals("C")) {
                sum -= list.removeLast();
            }
            else if (op.equals("D")) {
                list.add(list.peekLast() * 2);
                sum += list.peekLast();
            }
            else if (op.equals("+")) {
                list.add(list.peekLast() + list.get(list.size() - 2));
                sum += list.peekLast();
            }
            else {
                list.add(Integer.parseInt(op));
                sum += list.peekLast();
            }
        }
        return sum;
    }
} 
 */
 class 682BaseballGame{
    public int calPoints(String[] ops) {
        int sum = 0;
        int temp1[] = new int[ops.length];
        int count = 0;
        if ( ops.length >= 1 && ops.length <= 1000 ){
            for ( int i = 0; i < ops.length; i++ ){
                if ( ops[i].equals("C") ){
                    sum -= temp1[count - 1];
                    temp1[count - 1] = 0;
                    count--;
                    System.out.println("C");
                }
                else{
                    if ( ops[i].equals("D") )
                        temp1[count] = 2 * temp1[count-1];
                    else if ( ops[i].equals("+") )
                        temp1[count] = temp1[count-1] + temp1[count-2];
                    else if ( Integer.parseInt(ops[i]) >= -30000 && Integer.parseInt(ops[i]) <= 30000 )
                        temp1[count] = Integer.parseInt(ops[i]);
                    sum += temp1[count];
                    count++;                  
                }
            }
        }
        return sum;
    }
}