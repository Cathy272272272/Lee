/*            don't know why this line set all list<String> in list no matter any depth to the same......
                list.get(depth).set(pos, Integer.toString(root.val));
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
class 655PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        int h = height(root);
        int w = (int)(Math.pow(2, h)) - 1;
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        boolean visited = false;
        for ( int i = 0; i < h; i++ ) {
            if ( !visited ) {
                visited = true;
                for ( int j = 0; j < w; j++ ) {
                    temp.add("");
                }
            }
            list.add(temp);
        }
        add(root, list, 0, (int)(Math.pow(2, h - 1)) - 1, h);
        return list;
    }
    public int height ( TreeNode root ) {
        if ( root == null ) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    public void add ( TreeNode root, List<List<String>> list, int depth, int pos, int h ) {
        if ( root != null ) {
            List<String> temp = new ArrayList<String>(list.get(depth));
            temp.set(pos, Integer.toString(root.val));
            list.set(depth, temp);
            add(root.left, list, depth + 1, pos - (int)Math.pow(2, h - 1 - depth - 1), h );
            add(root.right, list, depth + 1, pos + (int)Math.pow(2, h - 1 - depth - 1), h );
        }  
    }
}