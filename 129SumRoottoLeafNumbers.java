/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 129SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return help(root, 0);
    }
    public int help(TreeNode root, int cur) {
        if ( root == null ) return 0;
        cur += root.val;
        if ( root.left == null && root.right == null ) {
            return cur;            
        }
        return help(root.left, 10 * cur) + help(root.right, 10 * cur);
    }
}