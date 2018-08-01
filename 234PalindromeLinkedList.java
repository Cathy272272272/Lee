/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class 234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if ( head == null ) return true;
        if ( head.next == null ) return true;
        ListNode slow = head, fast = head, pre = null, newHead = head;
        boolean odd = false;
        while ( fast != null ) {
            ListNode tmp = slow;
            slow = slow.next;
            fast = fast.next;
            if ( fast == null ) break;
            fast = fast.next;
            newHead = tmp;
            newHead.next = pre;
            pre = newHead;
        }
        while ( slow != null && newHead != null ) {
            if ( slow.val != newHead.val ) return false;
            slow = slow.next;
            newHead = newHead.next;
        }
        return slow == null && newHead == null;
    }
}