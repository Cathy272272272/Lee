/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 515FindLargestValueInEachTreeRow{
    int depth = 0;
    List<Integer> temp = new ArrayList<Integer>();
    public List<Integer> largestValues(TreeNode root) {
        largest(root, 0);
        return temp;
    }
    public void largest(TreeNode root, int depth) {
        int help;
        TreeNode i;
        if ( root != null ){
            depth++;
            if (temp.size() < depth )
                temp.add(root.val);
            else
                if ( temp.get(depth - 1) < root.val )
                    temp.set(depth - 1, root.val);
            largest(root.right, depth);
            largest(root.left, depth);
        }
    }
}