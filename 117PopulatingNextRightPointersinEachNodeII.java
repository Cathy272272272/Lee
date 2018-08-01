/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class 117PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        if ( root == null ) return;
        if ( root.right != null ) {
            TreeLinkNode tmp = root.next;
            while ( tmp != null ) {
                if ( tmp.left != null ) {
                    root.right.next = tmp.left;
                    break;
                }
                if ( tmp.right != null ) {
                    root.right.next = tmp.right;
                    break;
                }
                tmp = tmp.next;
            }
            connect(root.right);
        }
        if ( root.left != null ) {
            if ( root.right != null ) root.left.next = root.right;
            else {
                TreeLinkNode tmp = root.next;
                while ( tmp != null ) {
                    if ( tmp.left != null ) {
                        root.left.next = tmp.left;
                        break;
                    }
                    if ( tmp.right != null ) {
                        root.left.next = tmp.right;
                        break;
                    }
                    tmp = tmp.next;
                }
            }
            connect(root.left);
        }
    }
}