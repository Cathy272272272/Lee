/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 617MergeTwoBinaryTrees{
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode sum;
        if ( t1 == null && t2 == null ){
            return null;
        }
        else{
            if ( t1 == null ){
                sum = t2;
            }
            else if ( t2 == null ){
                sum = t1;
            }
            else{
                sum = new TreeNode(t1.val + t2.val);
                sum.left = mergeTrees(t1.left, t2.left);
                sum.right = mergeTrees(t1.right, t2.right);
            }
            return sum;
        }
    }
}