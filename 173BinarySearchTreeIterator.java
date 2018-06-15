/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class 173BinarySearchTreeIterator {
    //TreeNode root;
    Stack stack;
    public BSTIterator(TreeNode root) {
        //root = r;
        stack = new Stack();
        push(root);
    }
    public void push(TreeNode root) {
        if (root == null) return;
        push(root.right);
        stack.push(root.val);
        push(root.left);
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if ( stack.empty() ) return false;
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        return (Integer)stack.pop();
    }
        
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */