/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder s = new StringBuilder();
    boolean check = false;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if ( !check ) {
            helps(root);
            check = true;
        }       
        return s.toString();
    }
    public void helps(TreeNode root) {
        if ( root == null ) {
            s.append("#").append(",");
            return;
        }
        s.append(root.val).append(",");
        helps(root.left);
        helps(root.right);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringBuilder s = new StringBuilder();
        s.append(data);
        TreeNode root = helpd();
        return root;
    }
    public TreeNode helpd() {
        if ( s.charAt(0) == '#' ) {
            s.delete(0, 2);
            return null;
        }
        int idx = s.indexOf(",");
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, idx)));
        s.delete(0, idx+1);
        root.left = helpd(); 
        root.right = helpd();
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));