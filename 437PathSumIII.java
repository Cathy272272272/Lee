/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 437PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if ( root == null ) return 0;
        return help(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int help(TreeNode root, int sum) {
        if ( root == null ) return 0;
        if ( root.val == sum ) {
            return 1 + help(root.left, 0) + help(root.right, 0);
        }
        return help(root.left, sum - root.val) + help(root.right, sum - root.val);
    }
}