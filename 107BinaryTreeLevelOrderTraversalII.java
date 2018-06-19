/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 107BinaryTreeLevelOrderTraversalII {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        help(root, 1);
        return list;
    }
    public void help(TreeNode root, int depth) {
        if ( root == null ) return;
        List<Integer> tmp; 
        if ( list.size() < depth ) {
            tmp = new ArrayList<Integer>();
            tmp.add(root.val);
            list.add(0, tmp);
        }
        else {
            tmp = list.get(list.size() - depth);
            tmp.add(root.val);
        }
        help(root.left, depth + 1);
        help(root.right, depth + 1);
    }
}