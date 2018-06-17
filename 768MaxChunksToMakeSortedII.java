/*Clever......
 * Algorithm: Iterate through the array, each time all elements to the left are smaller (or equal) to all elements to the right, there is a new chunck.
Use two arrays to store the left max and right min to achieve O(n) time complexity. Space complexity is O(n) too.
This algorithm can be used to solve ver1 too.

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }

        minOfRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) res++;
        }

        return res + 1;
    }
}
*/
class 768MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        List<Integer> tmp;
        for ( int i = 0; i < n; i++ ) {
            tmp = new ArrayList<Integer>();
            map.put(arr[i], map.getOrDefault(arr[i], tmp));
            tmp = map.get(arr[i]);
            tmp.add(i);
        }
        int count = 0, j = 0, mark = 0;
        for ( int i : map.keySet() ) {
            tmp = map.get(i);
            for ( Integer k : tmp ) {
                if (k > mark ) mark = k;
                if ( j >= mark ) count++;
                j++;
            }
        }
        return  count;
    }
}