/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 671SecondMinimumNodeInaBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if ( root == null || root.right == null ) return -1;
        if ( root.left.val == root.right.val ) return -1;
        int tmp;
        if ( root.left.val > root.right.val ) {
            tmp = greater(root.right, root.val);
            if ( tmp == root.val ) return root.left.val;
            return Math.min(tmp,root.left.val);
        }
        tmp = greater(root.left, root.val);
        if ( tmp == root.val ) return root.right.val;
        return Math.min(tmp,root.right.val);
    }
    public int greater(TreeNode root, int val) {
        if ( root == null ) return val;
        if ( root.left == null && root.right == null ) return root.val;
        if ( root.left.val == val && root.right.val == val ) {
            int left = greater(root.left, val);
            int right = greater(root.right, val);
            if ( left == val ) return right;
            if ( right == val ) return left;
            return Math.min(greater(root.left, val), greater(root.right, val));
        }
        return Math.max(root.left.val, root.right.val);
    }
}