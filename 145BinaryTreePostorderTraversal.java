/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 145BinaryTreePostorderTraversal {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        help(root);
        return list;
    }
    public void help(TreeNode root) {
        if ( root == null ) return;
        if ( root.left == null && root.right == null ) {
            list.add(root.val);
            return;
        }
        if ( root.left != null ) help(root.left);
        if ( root.right != null ) help(root.right);
        list.add(root.val);
    }
}