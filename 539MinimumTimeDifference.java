/* similar idea, but others solution much faster
 * public class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            if (mark[h * 60 + m]) return 0;
            mark[h * 60 + m] = true;
        }
        
        int prev = 0, min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        
        min = Math.min(min, (24 * 60 - last + first));
        
        return min;
    }
}
*/
class 539MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int min = 24 * 60;
        int size = timePoints.size();
        int tmp;
        List<Integer> minutes = new ArrayList<Integer>();
        for ( String s : timePoints ) 
            minutes.add(Integer.parseInt(s.substring(0,2))*60 + Integer.parseInt(s.substring(3)));
        Collections.sort(minutes);
        for ( int i = 1; i < size; i++ ) {
            tmp = minutes.get(i) - minutes.get(i-1);
            if ( min > tmp )
                min = tmp;
        }
        tmp = 24 * 60 + minutes.get(0) - minutes.get(size-1);
        if ( tmp < min )
            min = tmp;
        return min;
    }
}