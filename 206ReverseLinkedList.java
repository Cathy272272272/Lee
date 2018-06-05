/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class 206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if ( head == null ) return null;
        if ( head.next == null ) return head;
        int val = head.val;
        ListNode help, prev = null;
        while ( head.next != null ) {
            help = head;
            head = head.next;
            help.next = prev;
            prev = help;
        }
        head.next = prev;
        return head;
    }
}