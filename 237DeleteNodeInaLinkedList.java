/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/* Easy solution......
 * public void deleteNode(ListNode node) {
    node.val=node.next.val;
    node.next=node.next.next;
}
 */
class 237DeleteNodeInaLinkedList {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while ( node.next != null ) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}