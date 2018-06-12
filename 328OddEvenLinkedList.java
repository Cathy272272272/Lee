/* So easy...... I am stupid......
public class Solution {
public ListNode oddEvenList(ListNode head) {
    if (head != null) {
    
        ListNode odd = head, even = head.next, evenHead = even; 
    
        while (even != null && even.next != null) {
            odd.next = odd.next.next; 
            even.next = even.next.next; 
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead; 
    }
    return head;
}}
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class 328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if ( head == null ) return null;
        if ( head.next == null || head.next.next == null ) return head;
        ListNode num = head;
        int count = 0, help;
        ListNode tmp = head.next.next, prev = head.next;
        int i;
        while ( tmp!= null ) {
            help = tmp.val;
            tmp.val = prev.val;
            prev.val = help;
            tmp = tmp.next;
            if ( tmp != null ) {
                prev = tmp;
                tmp = tmp.next;
            }
            if ( tmp != null ) count++;
        }
        ListNode start = head.next.next;
        while ( count > 0 ) {
            tmp = start.next;
            prev = start;
            i = 0;
            while ( i < count ) {
                help = tmp.val;
                tmp.val = prev.val;
                prev.val = help;
                prev = tmp.next;
                tmp = prev.next;
                i++;
            }
            count--;
            start = start.next;
        }
        return head;
    }
}