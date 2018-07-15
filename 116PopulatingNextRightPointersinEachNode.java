/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class 116PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if ( root == null ) return;
        root.next = null;
        help(root);
    }
    public void help(TreeLinkNode root) {
        if ( root.left == null ) return;
        root.left.next = root.right;
        if ( root.next == null ) root.right.next = null;
        else root.right.next = root.next.left;
        help(root.left);
        help(root.right);
    }
}