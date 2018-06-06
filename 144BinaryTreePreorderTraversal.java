/*
 * public List<Integer> preorderTraversal(TreeNode node) {
 List<Integer> list = new LinkedList<Integer>();
 Stack<TreeNode> rights = new Stack<TreeNode>();
 while(node != null) {
  list.add(node.val);
  if (node.right != null) {
   rights.push(node.right);
  }
  node = node.left;
  if (node == null && !rights.isEmpty()) {
   node = rights.pop();
  }
 }
    return list;
}
*/

/*
 * Recursive method with List as returning value:

 public List<Integer> preorderTraversal(TreeNode root) {
  List<Integer> pre = new LinkedList<Integer>();
  if(root==null) return pre;
  pre.add(root.val);
  pre.addAll(preorderTraversal(root.left));
  pre.addAll(preorderTraversal(root.right));
  return pre;
 }
 */

/*
 * Iterative method with Stack:
(I like this one.)
 public List<Integer> preorderIt(TreeNode root) {
  List<Integer> pre = new LinkedList<Integer>();
  if(root==null) return pre;
  Stack<TreeNode> tovisit = new Stack<TreeNode>();
  tovisit.push(root);
  while(!tovisit.empty()) {
   TreeNode visiting = tovisit.pop();
   pre.add(visiting.val);
   if(visiting.right!=null) tovisit.push(visiting.right);
   if(visiting.left!=null) tovisit.push(visiting.left);
  }
  return pre;
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
class 144BinaryTreePreorderTraversal {
    // recursion
    /*List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        add(root);
        return list;
    }
    public void add(TreeNode root) {
        if ( root == null ) return;
        list.add(root.val);
        add(root.left);
        add(root.right);
    }*/
    // iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList<Integer>();
        loop:
        while ( root != null ) {
            list.add(root.val);
            stack.push(root);
            while ( root.left != null ) {
                root = root.left;
                list.add(root.val);
                stack.push(root);
            }
            if ( stack.empty() ) break loop;
            TreeNode help = stack.pop().right;
            while ( help == null ) {
                if ( stack.empty() ) break loop;
                help = stack.pop().right;
            }
            root = help;
        }
        return list;
    }
}