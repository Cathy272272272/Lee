/*Binary Search Trees always have lower value on its left side and higher value on its right side?????????
 The algorithm could be simpler with this property.
 * class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        
        return root;
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
class 669TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        TreeNode temp;
        boolean check = false;
       if ( root == null ){
           return null;
       } 
       else{
           if ( root.val < L || root.val > R ){
               if ( root.left == null && root.right == null )
                   return null;
               else {
                   if ( root.left != null ){
                    temp = trimBST(root.left, L, R);
                    if ( temp != null ){
                        root = temp;
                        check = true;
                    }
                   }
                    if ( !check && root.right != null ){
                        temp = trimBST(root.right, L, R);
                        if ( temp != null ){
                            root = temp;
                            check = true;
                        }
                    }
                    if ( !check )
                        return null;
                    }
                }
           }
           root.left = trimBST(root.left, L, R);
           root.right = trimBST(root.right, L, R);
        return root;
    }
}
