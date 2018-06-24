/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class 21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if ( l1 == null ) return l2;
        if ( l2 == null ) return l1;
        ListNode tmp = l2;
        if ( l1.val > l2.val ) {l2 = l1; l1 = tmp;}
        ListNode l = new ListNode(l1.val);
        l1 = l1.next;
        ListNode help = l, ll;
        while(true) {
            if ( l1 == null ) {
                l.next = l2;
                break;
            }
            if ( l2 == null ) {
                l.next = l1;
                break;
            }
            if ( l1.val < l2.val ) {
                ll = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                ll = new ListNode(l2.val);
                l2 = l2.next;
            }
            l.next = ll;
            l = l.next;
        }
        return help;
    }
}