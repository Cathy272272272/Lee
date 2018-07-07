/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if ( root == null ) return true;
        int res = help(root.left) - help(root.right);
        return Math.abs(res) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int help(TreeNode root) {
        if ( root == null ) return 0;
        return 1 + Math.max(help(root.right), help(root.left));
    }
}