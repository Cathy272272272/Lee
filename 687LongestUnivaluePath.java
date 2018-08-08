/*
 * int len = 0; // global variable
public int longestUnivaluePath(TreeNode root) {
    if (root == null) return 0;
    len = 0;
    getLen(root, root.val);
    return len;
}

private int getLen(TreeNode node, int val) {
    if (node == null) return 0;
    int left = getLen(node.left, node.val);
    int right = getLen(node.right, node.val);
    len = Math.max(len, left + right);
    if (val == node.val)  return Math.max(left, right) + 1;
    return 0;
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
    public int longestUnivaluePath(TreeNode root) {
        if ( root == null ) return 0;
        //int count = (root.left != null && root.left.val == root.val ? 1 + count(root.left, root.val) : 0) + (root.right != null && root.right.val == root.val ? 1 + count(root.right, root.val) : 0);
        //return Math.max(count, Math.max(help(root.left, root.val), help(root.right, root.val)));
        return help(root, root.val + 1);
    }
    public int help(TreeNode root, int cur) {
        if ( root == null ) return 0;
        if ( root.val == cur ) {
            return Math.max(help(root.left, cur), help(root.right, cur));
        }
        return Math.max((root.left != null && root.left.val == root.val ? 1 + count(root.left, root.val) : 0) + (root.right != null && root.right.val == root.val ? 1 + count(root.right, root.val) : 0), Math.max(help(root.left, root.val), help(root.right, root.val)));
    }
    public int count(TreeNode root, int val) {
        if ( root == null ) return 0;
        int count = 0;
        if ( root.left != null ) if ( root.left.val == val ) count = 1 + count(root.left, val);
        if (root.right != null ) if ( root.right.val == val ) count = Math.max(count, 1 + count(root.right, val));
        return count;
    }
}