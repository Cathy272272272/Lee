/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if ( root == null )
            return null;
        else{
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
            }
        return root;
        }
    }
