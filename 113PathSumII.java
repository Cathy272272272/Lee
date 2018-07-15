/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 113PathSumII {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if ( root == null ) return list;
        help(root, sum, new ArrayList<Integer>());
        return list;
    }
    public void help(TreeNode root, int sum, List<Integer> l) {
        if ( root == null ) {
            return;
        }
        l.add(root.val);
        if ( root.left == null && root.right == null ) {
            if ( sum - root.val == 0 ) list.add(new ArrayList<Integer>(l)); 
            return;
        }
        int size = l.size();
        help(root.left, sum - root.val, l);
        help(root.right, sum - root.val, l.subList(0, size));
    }
}