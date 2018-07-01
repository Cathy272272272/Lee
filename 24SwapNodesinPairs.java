/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class 24SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if ( head == null ) return null;
        if ( head.next == null ) return head;
        ListNode tmp = head.next;
        head.next = swapPairs(head.next.next);
        tmp.next = head;
        return tmp;
    }
}/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if ( head == null ) return null;
        if ( head.next == null ) return head;
        //ListNode tmp = head.next.next;
        //head.next.next = head;
        //ListNode ans = head.next.next;
        head.next.next = swapPairs(head.next.next);
        int tmp = head.val;
        head.val = head.next.val;
        head.next.val = tmp;
        return head;
    }
}