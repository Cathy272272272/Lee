/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 106ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if ( n == 0 ) return null;
        for ( int i = 0; i < n; i++ ) {
            if ( inorder[i] == postorder[n-1] ) {
                TreeNode root = new TreeNode(inorder[i]);
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(inorder, i+1, n), Arrays.copyOfRange(postorder, i, n-1));   
                return root;
            }
        }
        return null;
    }
}