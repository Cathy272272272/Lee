/* clever method
 * DFS without helper function, similar to @alexander 's top post
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d < 2) {
            TreeNode newroot = new TreeNode(v);
            if (d == 0) newroot.right = root;
            else newroot.left = root;
            return newroot;
        }
        if (root == null) return null;
        root.left = addOneRow(root.left, v, d == 2 ? 1 : d-1);
        root.right = addOneRow(root.right, v, d == 2 ? 0 : d-1);
        return root;
    }
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
class 623AddOneRowtoTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if ( root == null ) return root;
        if ( d == 1 ) {
            TreeNode one = new TreeNode(v);
            one.left = root;
            return one;
        }
        next(root, v, d, 1);
        return root;
    }
    public void next(TreeNode root, int v, int d, int cur) {
        if ( root == null ) return;
        if ( cur != d - 1 ) {
            next(root.left,v,d,cur+1);
            next(root.right,v,d,cur+1);
        }
        else {
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = new TreeNode(v);
        root.right = new TreeNode(v);
        root.left.left = left;
        root.right.right = right;
        }
    }
}