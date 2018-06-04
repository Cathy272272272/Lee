/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* Same answer to 530......
 * Don't use Integer.MIN_VALUE, Integer.MAX_VALUE, you will get strange result for plus or minus......
 */
class 783MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        return (int)(find(root));
    }
    public double find( TreeNode root) {
        if ( root == null ) return Double.POSITIVE_INFINITY;
        double leftMax, rightMin, leftNodeMin, rightNodeMin, rootMin;
        TreeNode left = root.left;
        if ( left == null ) leftMax = Double.NEGATIVE_INFINITY;
        else {
            while ( left.right != null ) left = left.right;
            leftMax = left.val;
        }
        TreeNode right = root.right;
        if ( right == null ) rightMin = Double.POSITIVE_INFINITY;
        else {
            while ( right.left != null ) right = right.left; 
            rightMin = right.val;
        }
        leftNodeMin = find(root.left); 
        rightNodeMin = find(root.right);
        rootMin = Math.min(root.val - leftMax, rightMin - root.val);
        return Math.min(leftNodeMin, Math.min(rightNodeMin, rootMin));
    }
}