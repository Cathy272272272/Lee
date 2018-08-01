https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
/*
 * Same idea from a fantastic sliding window template, please refer:
https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems

Time Complexity will be O(n) because the "start" and "end" points will only move from left to right once.

public List<Integer> findAnagrams(String s, String p) {
    List<Integer> list = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
    int[] hash = new int[256]; //character hash
    //record each character in p to hash
    for (char c : p.toCharArray()) {
        hash[c]++;
    }
    //two points, initialize count to p's length
    int left = 0, right = 0, count = p.length();
    while (right < s.length()) {
        //move right everytime, if the character exists in p's hash, decrease the count
        //current hash value >= 1 means the character is existing in p
        if (hash[s.charAt(right++)]-- >= 1) count--; 
        
        //when the count is down to 0, means we found the right anagram
        //then add window's left to result list
        if (count == 0) list.add(left);
    
        //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
        //++ to reset the hash because we kicked out the left
        //only increase the count if the character is in p
        //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
        if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
    }
    return list;
}
*/
class 438FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int len = p.length();
        int n = s.length();
        if ( n < len ) return ans;
        int[] a = new int[26];
        int[] b = new int[26];
        for ( int i = 0; i < len; i++ ) {
            a[s.charAt(i) - 'a']++;
            b[p.charAt(i) - 'a']++;
        }
        if ( check(a, b, p) ) ans.add(0);
        for ( int i = 1; i <= n - len; i++ ) {
            a[s.charAt(i-1) - 'a']--;
            a[s.charAt(i-1+len) - 'a']++;
            if ( check(a, b, p) ) ans.add(i);
        }
        return ans;
    }
    public boolean check(int[] a, int[] b, String p) {
        for(char i : p.toCharArray() ) {
            if ( a[i - 'a'] != b[i - 'a'] ) return false;
        }
        return true;
    }
}