/*Clever slow fast solution......
 * public class Solution {
public TreeNode sortedListToBST(ListNode head) {
    if(head==null) return null;
    return toBST(head,null);
}
public TreeNode toBST(ListNode head, ListNode tail){
    ListNode slow = head;
    ListNode fast = head;
    if(head==tail) return null;
    
    while(fast!=tail&&fast.next!=tail){
        fast = fast.next.next;
        slow = slow.next;
    }
    TreeNode thead = new TreeNode(slow.val);
    thead.left = toBST(head,slow);
    thead.right = toBST(slow.next,tail);
    return thead;
}
}
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 109ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if ( head == null ) return null;
        List<Integer> list = new ArrayList<>();
        while ( head != null ) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        return add(list);
    }
    public TreeNode add(List<Integer> list) {
        int size = list.size();
        if ( size == 0 ) return null;
        TreeNode t = new TreeNode(list.get(size/2));
        t.left = add(list.subList(0, size/2));
        t.right = add(list.subList(size/2 + 1, size));
        return t;
    }
}