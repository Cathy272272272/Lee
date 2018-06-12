//Lol......I forget to do one question today, and I did it in ten minutes, quite happy......
/*
 * For every node, length of longest path which pass it = MaxDepth of its left subtree + MaxDepth of its right subtree.

public class Solution {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        max = Math.max(max, left + right);
        
        return Math.max(left, right) + 1;
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
class 543DiameterofBinaryTreeion {
    public int diameterOfBinaryTree(TreeNode root) {
        if ( root == null ) return 0;
        return (int)Math.max(sum(root), (int)Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
    }
    public int count(TreeNode root) {
        if ( root == null ) return 0;
        return 1 + (int)Math.max(count(root.right), count(root.left));
    }
    public int sum(TreeNode root) {
        if ( root == null ) return 0;
        return count(root.right) + count(root.left);
    }
}