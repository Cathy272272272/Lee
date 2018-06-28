/* O(n) preorder traversal
 * public class Solution {
 public boolean isSubtree(TreeNode s, TreeNode t) {
        String spreorder = generatepreorderString(s); 
        String tpreorder = generatepreorderString(t);
        
        return spreorder.contains(tpreorder) ;
    }
    public String generatepreorderString(TreeNode s){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stacktree = new Stack();
        stacktree.push(s);
        while(!stacktree.isEmpty()){
           TreeNode popelem = stacktree.pop();
           if(popelem==null)
              sb.append(",#"); // Appending # inorder to handle same values but not subtree cases
           else      
              sb.append(","+popelem.val);
           if(popelem!=null){
                stacktree.push(popelem.right);    
                stacktree.push(popelem.left);  
           }
        }
        return sb.toString();
    }
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
class 572SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if ( t == null ) return true;
        if ( s == null ) return false;
        if ( help(s, t) ) return true;
        //System.out.println(s.val);
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public boolean help(TreeNode s, TreeNode t) {
        if ( s == null && t == null ) return true;
        if ( s == null || t == null ) return false;
        if ( s.val != t.val ) return false;
        return help(s.left, t.left) && help(s.right, t.right);
    }
}