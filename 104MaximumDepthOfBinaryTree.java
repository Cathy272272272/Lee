/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 104MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if ( root == null )
            return 0;
        int lheight = 1;
        int rheight = 1;
        TreeNode r = root;
        if ( r.left != null ){
            r = r.left;
            lheight = 1 + maxDepth(r);
        }
        if ( root.right != null ){
            root = root.right;
            rheight = 1 + maxDepth(root);
        }
        return Math.max(rheight, lheight);
    }
}