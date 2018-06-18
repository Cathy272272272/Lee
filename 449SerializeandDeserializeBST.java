/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class 449SerializeandDeserializeBST {
    //Stack<String> stack = new Stack<String>();
    StringBuilder s = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        helps(root);
        return s.toString();
    }
    public void helps(TreeNode root) {
        if ( root == null ) return;
        s.append(root.val).append("/");
        helps(root.left);
        helps(root.right);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int l = data.length();
        if (l == 0 ) return null;
        int index = 0, val = 0, tmp = 0;
        while ( data.charAt(index) != '/' && index < l) index++;
        if ( index == l - 1) {
            TreeNode root = new TreeNode(Integer.parseInt(data.substring(0, l - 1)));
            root.left = null;
            root.right = null;
            return root;
        }
        else val = Integer.parseInt(data.substring(0,index));
        index++;
        TreeNode root = new TreeNode(val);
        int i = index, help = index;
        for ( i = help; i < l; i++ ) {
            index = i + 1;
            while ( data.charAt(index) != '/' && index < l ) index++;
            tmp = Integer.parseInt(data.substring(i,index));
            if (tmp > val) break;
            i = index;
        }
        root.left = deserialize(data.substring(help, i));
        root.right = deserialize(data.substring(i));
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));