/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 814BinaryTreePruning{
    public TreeNode pruneTree(TreeNode root) {
        if (  root == null )
            return null;
        else{
                root.left = pruneTree(root.left);
                root.right = pruneTree(root.right);
            if ( root.left == null && root.right == null ){
                if ( root.val == 0 )
                    root = null;
            }
            return root;
        }        
    }
}