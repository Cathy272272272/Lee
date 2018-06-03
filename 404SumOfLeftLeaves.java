/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 404SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        TreeNode tmp;
        if ( root == null ) return 0;
        tmp = root;
        while ( tmp.left != null ) {
            tmp = tmp.left;
            sum += sumOfLeftLeaves(tmp.right);
        }
        if ( root.left != null && tmp.right == null )
            sum += tmp.val;
        return sum += sumOfLeftLeaves(root.right); 
    }
}