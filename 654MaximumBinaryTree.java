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
 * class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }
        
        return stack.isEmpty() ? null : stack.removeLast();
    }
}
*/
class 654MaximumBinaryTree{
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if ( nums.length >= 0 ){
            if ( nums.length == 1 )
                return new TreeNode(nums[0]);
        if ( nums.length >= 1 && nums.length <= 1000 ){
            int max = nums[0];
            int mark = 0;
            int i;
            for ( i = 1; i < nums.length; i++ )
                if ( nums[i] > max ){
                    max = nums[i];
                    mark = i;
                }
            TreeNode root = new TreeNode(nums[mark]);
            if ( mark - 1 >= 0 ){ // largest number at the begining
                int[] lArray = new int[mark];
                for ( int j = 0; j < mark; j++ )
                    lArray[j] = nums[j];
                root.left = constructMaximumBinaryTree( lArray );
            }
            if ( mark <= nums.length - 1 ){
                int[] rArray = new int[nums.length - 1 - mark];
                for ( int j = 0; j < nums.length - 1 - mark; j++ )
                    rArray[j] = nums[mark + 1 + j];
                root.right = constructMaximumBinaryTree ( rArray );
            }
            return root;
        }
    }
        return null;
    }
}