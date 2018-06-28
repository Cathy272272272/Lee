/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class 83RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if ( head == null ) return head;
        int tmp = head.val;
        ListNode help = head.next, prev = head;
        while ( help != null ) {
            //System.out.println(help.val);
            if ( help.val == tmp ) {
                prev.next = help.next;
            }
            else {
                tmp = help.val;
                prev = prev.next;
                if ( prev == null ) break;
            }
            help = prev.next;
        }
        return head;
    }
}