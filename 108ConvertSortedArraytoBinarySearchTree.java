/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 108ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if ( n == 0 ) return null;
        TreeNode root = add(nums, 0, n-1);
        return root;
    }
    public TreeNode add(int[] nums, int lo, int high) {
        if ( lo > high ) return null;
        int mid = (lo+high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = add(nums, lo, mid-1);
        root.right = add(nums, mid+1, high);
        return root;
    }
}