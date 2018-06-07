/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class 725SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode tmp = root;
        int size = 0;
        while ( tmp != null ) {
            size++;
            tmp = tmp.next;
        }
    int smallSize = size / k;
    int remainder = size % k;
    ListNode[] res = new ListNode[k];
    for ( int i = 0; i < k; i++ ) {
        int count = 0, siz;
        if ( i < remainder ) {
            siz = smallSize;
        }
        else siz = smallSize - 1;
            res[i] = root;
        if ( siz == -1 ) {
            res[i] = null;
            continue;
        }
        while ( count < siz ) {
            root = root.next;
            count++;
        }
        ListNode temp = root;
        root = root.next;
        temp.next = null;
    }
        return res;
    }
}