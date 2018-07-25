/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class 141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode quick = head, slow = head;
        boolean first = false;
        while ( quick != null && slow != null ) {
            if ( quick == slow && first ) return true;
            slow = slow.next;
            quick = quick.next;
            if ( quick == null ) return false;
            quick = quick.next;
            first = true;
        }
        return false;
    }
}