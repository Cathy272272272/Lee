/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 102BinaryTreeLevelOrderTraversal {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if ( root == null ) return list;
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(root.val);
        list.add(tmp);
        add(root, 2);
        return list;
    }
    public void add(TreeNode root, int depth) {
        if ( root == null ) return;
        if ( root.left == null && root.right == null ) return;
        List<Integer> tmp;
        if ( list.size() < depth ) {
            tmp = new ArrayList<Integer>();
            if ( root.left != null ) tmp.add(root.left.val);
            if ( root.right != null ) tmp.add(root.right.val);
            list.add(tmp);
        }
        else {
            //tmp = new ArrayList<Integer>();
            tmp = list.get(depth - 1);
            if ( root.left != null ) tmp.add(root.left.val);
            if ( root.right != null ) tmp.add(root.right.val);
            //list.set(depth - 1, tmp);
        }
        add(root.left, depth + 1 );
        add(root.right, depth + 1);
    }
}