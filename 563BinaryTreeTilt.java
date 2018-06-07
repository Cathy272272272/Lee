/*
 * public class Solution {
    int result = 0;
    
    public int findTilt(TreeNode root) {
        postOrder(root);
        return result;
    }
    
    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        
        result += Math.abs(left - right);
        
        return left + right + root.val;
    }
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
class 563BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        if ( root == null ) return 0;  
        int sum;
        if ( root.right == null && root.left == null ) sum = 0;
        else if ( root.right == null ) sum = Math.abs(sum(root.left));
        else if ( root.left == null ) sum = Math.abs(sum(root.right));
        else sum = Math.abs(sum(root.left) - sum(root.right));
        return findTilt(root.left) + findTilt(root.right) + sum;
    }
    public int sum(TreeNode root) {
        if ( root == null ) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
}