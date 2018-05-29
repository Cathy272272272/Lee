/*Iterative method, so clever......
 * public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;

    while(cur!=null || !stack.empty()){
        while(cur!=null){
            stack.add(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        list.add(cur.val);
        cur = cur.right;
    }

    return list;
}
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 94BinaryTreeInorderTraversal {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if ( root == null ) return list;
        list.add (root.val);
        find(root, 0);
        return list;
    }
    public void find(TreeNode root, int index) {
        if ( root != null ) {
            int rIndex;
            int lIndex;
            if ( root.right != null ) { 
                rIndex = index + 1;
                list.add(rIndex, root.right.val);
                find(root.right, rIndex);
            }

            if ( root.left != null ) {
                lIndex = index;
                list.add(index, root.left.val);
                find(root.left, lIndex );
            }
        }
    }
}
