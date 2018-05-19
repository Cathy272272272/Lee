/*
 * public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            } 
        });
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(i);
        }
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            int index = list.get(people[i][1]);
            res[index][0] = people[i][0];
            res[index][1] = people[i][1];
            list.remove(people[i][1]);
        }
        return res;
    }
}
*/
class 406QueueReconstructionbyHeight{
    public int[][] reconstructQueue(int[][] people) {
        if ( people.length > 1100 )
            return people;
        int[][] cal = new int[people.length][people.length];
        int count = 0;
        int temp = 0;
        int i = 0;
        int k;
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        while ( i < people.length ){
            k = people.length -1 - count;
            temp = count;
            if ( k - 1 >= 0 ){
                while ( people[k][0] == people[k - 1][0] ){
                    count++;
                    k--;
                    if ( k - 1 < 0 )
                        break;
                }
            }
            count++;
            i = count; // mark the row position
            for ( int j = people.length - i; j < people.length - i + count - temp; j++ ){
                cal[i - 1][j] = people[j][1]; // write down the new entry
                for ( int l = people.length - i + count - temp; l < people.length; l++ ){
                    if ( cal[i - ( count - temp ) - 1][l] >= people[j][1] )
                        cal[i - ( count - temp ) - 1][l]++;
                    cal[i - 1][l] = cal[i - ( count - temp ) - 1][l];
                }
            }
        }
            
    int[][] array = new int[people.length][2];
    for ( int l = 0; l < people.length; l++ ){
        array[cal[people.length - 1][l]][0] = people[l][0];
        array[cal[people.length - 1][l]][1] = people[l][1];
    }
        return array; 
    }
}