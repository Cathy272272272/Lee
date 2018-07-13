/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 114FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if ( root == null ) return;
        flat(root);
    }
    public TreeNode flat(TreeNode root) {
        if ( root == null ) return root;
        if ( root.left == null ) root.right = flat(root.right);
        else {
            TreeNode help = root;
            TreeNode tmp = help.right;
            help.right = flat(help.left);
            help.left = null;
            while ( help.right != null ) {
                help = help.right;
            }
            help.right = flat(tmp);
        }
        return root;
    }
}