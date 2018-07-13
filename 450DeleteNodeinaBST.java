/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 450DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if ( root == null ) return null;
        if ( root.val == key ) {
            if ( root.left == null && root.right == null ) return null;
            if ( root.left == null ) return root.right;
            if ( root.right == null ) return root.left;
            add(root);
            return root;
        }
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;
    }
    public void add(TreeNode root) {
        if ( root == null ) return;
        if ( root.right != null ) {
        root.val = help(root, root.right, root.right.val);
        }
    }
    public int help(TreeNode p, TreeNode t, int cur) {
        if ( t == null ) return cur;
        if ( t.left != null ) {
            cur = t.left.val;
            return help(t, t.left, cur);
        }
        else {
            if ( t.right != null ) add(t);
            else {
                if ( p.left != null ) {
                    if ( p.left == t ) {
                        p.left = null;
                        return cur;
                    }
                }
                if ( p.right != null ) {
                    if ( p.right == t ) {
                        p.right = null;
                        return cur;
                    }
                }
            }
            return cur;
        }
    }
}