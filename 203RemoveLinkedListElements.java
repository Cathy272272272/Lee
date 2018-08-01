/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class 203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if ( head == null ) return null;
        ListNode pre = head;
        while ( pre != null ) {
            if ( pre.val != val ) break;
            pre = pre.next;
        }
        ListNode newhead = pre;
        if ( pre == null ) return null;
        ListNode cur = pre.next;
        while ( cur != null ) {
            if ( cur.val == val ) {
                pre.next = cur.next;
                cur = pre.next;
                continue;
            }
            pre = cur;
            cur = cur.next;
        }
        return newhead;
    }
}