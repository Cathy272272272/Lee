/*Clever......
 *  public boolean isSymmetric(TreeNode root) {
    if(root==null) return true;
    return isMirror(root.left,root.right);
}
public boolean isMirror(TreeNode p, TreeNode q) {
    if(p==null && q==null) return true;
    if(p==null || q==null) return false;
    return (p.val==q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
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
class Solution {
    StringBuilder left = new StringBuilder();
    StringBuilder right = new StringBuilder();
    public boolean isSymmetric(TreeNode root) {
        left(root);
        right(root);
        return left.toString().equals(right.toString());
    }
    public void left(TreeNode root) {
        if ( root == null ) { left.append(" "); return;}
        left.append(root.val);
        left(root.left);
        left(root.right);
    }
    public void right(TreeNode root) {
        if ( root == null ) { right.append(" "); return;}
        right.append(root.val);
        right(root.right);
        right(root.left);
    }
}