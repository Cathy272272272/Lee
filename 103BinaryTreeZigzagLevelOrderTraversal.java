/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 103BinaryTreeZigzagLevelOrderTraversal {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if ( root == null ) return list;
        help(root, 0);
        return list;
    }
    public void help(TreeNode root, int depth) {
        if ( root == null ) return;
        if ( depth == list.size() ) list.add(new ArrayList<Integer>());
        List<Integer> l = list.get(depth);
        if ( depth % 2 == 0 ) {
            l.add(root.val);
        }
        else l.add(0, root.val);
        help(root.left, depth+1);
        help(root.right, depth+1);
    }
}