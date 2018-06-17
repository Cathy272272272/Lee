/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 199BinaryTreeRightSideView {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        help(root, 1);
        return list;
    }
    public void help(TreeNode root, int depth) {
        if ( root == null ) return;
        if ( list.size() < depth )
            list.add(root.val);
        else list.set(depth-1, root.val);
        help(root.left, depth+1);
        help(root.right, depth+1);
    }
}
/* More intuitive one, no need set......
 * 
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        help(root, 1);
        return list;
    }
    public void help(TreeNode root, int depth) {
        if ( root == null ) return;
        if ( list.size() < depth )
            list.add(root.val);
        //else list.set(depth-1, root.val);
        help(root.right, depth+1);
        help(root.left, depth+1);
    }
}
 */