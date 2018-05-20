/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
 * Mine is too complicated, run time too long......
 * see others good answer......
 * res[] is so important!!!!!!
 * Since it is an array, it is a reference.
 * When returned, the value res[1] is remaiined.
 * If use an int instead of int[], when returned, the value won't be remained.
 * public class Solution {
    int ans=0, h=0;
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return ans;
    }
    public void findBottomLeftValue(TreeNode root, int depth) {
        if (h<depth) {ans=root.val;h=depth;}
        if (root.left!=null) findBottomLeftValue(root.left, depth+1);
        if (root.right!=null) findBottomLeftValue(root.right, depth+1);
    }
}
No global variables, 6ms (faster):

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, 1, new int[]{0,0});
    }
    public int findBottomLeftValue(TreeNode root, int depth, int[] res) {
        if (res[1]<depth) {res[0]=root.val;res[1]=depth;}
        if (root.left!=null) findBottomLeftValue(root.left, depth+1, res);
        if (root.right!=null) findBottomLeftValue(root.right, depth+1, res);
        return res[0];
    }
}
*/
class 513FindBottomLeftTreeValue{
    public int findBottomLeftValue(TreeNode root) {
        return findHeight(root)[1];
    }
    public int[] findHeight(TreeNode root){
        int lheight = 0;
        int rheight = 0;
        int height = 0;
        int val;
        int[] array = new int[2];
            if ( root.left!= null && root.right != null ){
                lheight = 1 + findHeight(root.left)[0];
                rheight = 1 + findHeight(root.right)[0];
                if ( lheight >= rheight ){
                    height = lheight;
                    val = findHeight(root.left)[1];
                }
                else{
                    height = rheight;
                    val = findHeight(root.right)[1];
                }
            }
            else if ( root.left != null ){
                    height = 1 + findHeight(root.left)[0];
                    val = findHeight(root.left)[1];
                }
            else if ( root.right != null){
                    height = 1 + findHeight(root.right)[0];
                    val = findHeight(root.right)[1];
                }
            else{
                height = 1;
                val = root.val;
            }
        array[0] = height;
        array[1] = val;
        return array;
    }
}