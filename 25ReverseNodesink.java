/* In place
 * Hi, guys!
Despite the fact that the approach is recursive, the code is less than 20 lines. :)

public ListNode reverseKGroup(ListNode head, int k) {
    ListNode curr = head;
    int count = 0;
    while (curr != null && count != k) { // find the k+1 node
        curr = curr.next;
        count++;
    }
    if (count == k) { // if k+1 node is found
        curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
        // head - head-pointer to direct part, 
        // curr - head-pointer to reversed part;
        while (count-- > 0) { // reverse current k-group: 
            ListNode tmp = head.next; // tmp - next head in direct part
            head.next = curr; // preappending "direct" head to the reversed list 
            curr = head; // move head of reversed part to a new node
            head = tmp; // move "direct" head to the next node in direct part
        }
        head = curr;
    }
    return head;
}
Hope it helps!
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class 25ReverseNodesink-Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if ( head == null || k == 1 ) return head;
        ListNode copy = new ListNode(head.val);
        ListNode prev = head, cur = head.next;
        if ( cur == null ) return head;
        ListNode help = copy;
        copy.next = new ListNode(head.next.val);
        copy = copy.next;
        ListNode end = prev;
        prev.next = null;
        for ( int i = 0; i < k - 1; i++ ) {
            ListNode tmp = prev;
            prev = cur;
            cur = cur.next;
            prev.next = tmp;
            if ( cur == null ) return i == k - 2 ? prev : help;
            copy.next = new ListNode(cur.val);
            copy = copy.next;
        }
        end.next = reverseKGroup(cur, k);
        return prev;
    }
}