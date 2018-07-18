/*
 * public int longestSubstring(String s, int k) {
    char[] str = s.toCharArray();
    return helper(str,0,s.length(),k);
}
private int helper(char[] str, int start, int end,  int k){
    if (end - start < k) return 0;//substring length shorter than k.
    int[] count = new int [26];
    for (int i = start; i<end; i++) {
        int idx = str[i] - 'a';
        count[idx]++;
    }
    for (int i=0; i<26; i++) {
        if (count[i] < k && count[i] > 0) { //count[i]=0 => i+'a' does not exist in the string, skip it.
            for (int j = start; j<end; j++) {
                if (str[j] == i+'a') {
                    int left = helper(str, start, j, k);
                    int right = helper(str, j+1, end, k);
                    return Math.max(left, right);
                }
            }
        }
    }
    return end - start;
}
*/
class 395LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if ( n == 0 ) return 0;
        int[][] a = new int[26][2];
        for ( char i : s.toCharArray() ) {
            a[i-'a'][0]++;
            a[i-'a'][1] = i - 'a';
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((s1, s2) -> s1[0] - s2[0]);
        for ( int[] i : a ) {
            if ( i[0] == 0 ) continue;
            pq.offer(i);
        }
        if ( pq.peek()[0] >= k ) return n;
        int preidx = -1, idx;
        char tmp = (char)(pq.peek()[1] + 'a');
        int max = 0;
        while ( true ) {
            idx = s.indexOf(tmp, preidx + 1);
            if ( idx == -1 ) break;
            max = Math.max(max, longestSubstring(s.substring(preidx + 1, idx), k));
            preidx = idx;
        }
        max = Math.max(max, longestSubstring(s.substring(preidx + 1), k));
        return max;
    }
}