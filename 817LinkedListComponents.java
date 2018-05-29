/* Learn HashSet......
 *     public int numComponents(ListNode head, int[] G) {
        Set<Integer> setG = new HashSet<>();
        for (int i: G) setG.add(i);
        int res = 0;
        while (head != null) {
            if (setG.contains(head.val) && (head.next == null || !setG.contains(head.next.val))) res++;
            head = head.next;
        }
        return res;
    }
    */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class 817LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        if ( head == null ) return 0;
        int N = 0;
        int Gl = G.length;
        int count = 0;
        int i = Gl;
        if ( Gl > 10000 || Gl < 1 ) return 0;
        ListNode cur, start;
        start = head;
        cur = head;
        while ( cur != null ) {
            if ( i == Gl ) {
            count++;
            if ( cur == head ) start = head;
            else start = cur.next;
            Search:
            while ( start != null ) {
                for ( i = 0; i < Gl; i++ ) {
                    if ( start.val == G[i] )
                        break Search;
                }
                start = start.next;
                N++;
                if ( N > 10000 ) return 0;
            }
            if ( start == null ) return --count;
            cur = start.next;
            if ( cur == null ) return count;
            }
            N++;
            if ( N > 100000 ) return 0;
            for ( i = 0; i < Gl; i++ ) {
                if ( cur.val == G[i] ) {
                    cur = cur.next;
                    if ( cur == null ) return count;
                    break;
                }
            }
        }
        return count;
    }
}