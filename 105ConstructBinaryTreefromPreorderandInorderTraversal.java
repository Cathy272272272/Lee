/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 105ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] pre, int[] in) {
        int n = pre.length, i, idx = 0;
        if ( idx == n ) return null;
        TreeNode root = new TreeNode(pre[idx]);
        if ( idx == n - 1 ) return root;
        //find the idx of root in inorder[]
        for ( i = 0; i < n; i++ ) if ( in[i] == pre[idx] ) break;
        root.right = buildTree(Arrays.copyOfRange(pre, i+1, n), Arrays.copyOfRange(in, i+1, n));
        root.left = buildTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
        return root; 
    }
}