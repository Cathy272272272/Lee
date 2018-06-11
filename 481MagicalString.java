/*
 * 
I think it is similar, but mine is slow, since I use two list......

Create an int array a and initialize the first 3 elements with 1, 2, 2.
Create two pointers head and tail. head points to the number which will be used to generate new numbers. tail points to the next empty position to put the new number. Then keep generating new numbers until tail >= n.
Need to create the array 1 element more than n to avoid overflow because the last round head might points to a number 2.
A trick to flip number back and forth between 1 and 2: num = num ^ 3
public class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        
        int[] a = new int[n + 1];
        a[0] = 1; a[1] = 2; a[2] = 2;
        int head = 2, tail = 3, num = 1, result = 1;
        
        while (tail < n) {
            for (int i = 0; i < a[head]; i++) {
                a[tail] = num;
                if (num == 1 && tail < n) result++;
                tail++;
            }
            num = num ^ 3;
            head++;
        }
        
        return result;
    }
}
*/
class 481MagicalString {
    List<Integer> list1 = new ArrayList<Integer>();
    List<Integer> list2 = new ArrayList<Integer>();
    public int magicalString(int n) {
        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(2);
        list2.add(2);
        int choice, count = 0;;
        if ( n < 4 ) choice = 2;
        else choice = gen(n);
        if ( choice == 1 ) {
            for ( int i = 0; i < n; i++ )
                if ( list1.get(i) == 1 )
                    count++;
        }
        else
            for ( int i = 0; i < n; i++ )
                if ( list2.get(i) == 1 )
                    count++;
        return count;
    }
    public int gen ( int n ) {
        int size1 = list1.size();
        int size2 = list2.size();
        int tmp, index1, index2;
        if ( size1 < size2 ) {
            for ( int i = size1; i < size2; i++ )
                list1.add(list2.get(i));
            index1 = size2 - 1;
            index2 = size1;
            for ( int i = index2; i < size2; i++ ) {
                if ( list1.get(index1) == 1 )
                    tmp = 2;
                else tmp = 1;
                for ( int j = 0; j < list2.get(i); j++ ) {
                    list1.add(tmp);
                    index1++;
                }
            }
            if ( list1.size() >= n ) return 1;
        }
        else {
            for ( int i = size2; i < size1; i++ )
                list2.add(list1.get(i));
            index2 = size1 - 1;
            index1 = size2;
            for ( int i = size2; i < size1; i++ ) {
                if ( list2.get(index2) == 1 )
                    tmp = 2;
                else tmp = 1;
                for ( int j = 0; j < list1.get(i); j++ ) {
                    list2.add(tmp);
                    index2++;
                }
            }
            if ( list2.size() >= n ) return 2;
        }
        return gen(n);
    }
} 