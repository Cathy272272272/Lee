/*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while ((root.val - p.val) * (root.val - q.val) > 0)
        root = p.val < root.val ? root.left : root.right;
    return root;
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
class 235LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null ) return null;
        if ( (!contains(root.left, p) && !contains(root.right, p)) || (!contains(root.left, q) && !contains(root.right, q)) ) return root; 
        if ( contains(root.left, p) && contains(root.right, q) || contains(root.right, p) && contains(root.left, q) ) return root;
        if ( contains(root.left, p) && contains(root.left, q) ) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
    public boolean contains(TreeNode root, TreeNode p) {
        if ( root == null ) return false;
        if ( equals(root, p)) return true;
        return contains(root.left, p) || contains(root.right, p);
    }
    public boolean equals(TreeNode root, TreeNode p) {
        if ( p == null && root == null) return true;
        if ( root == null ) return false;
        if ( p.val != root.val ) return false;
        return equals(root.left, p.left) && equals(root.right, p.right);
    }
}