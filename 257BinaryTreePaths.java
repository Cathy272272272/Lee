/*
 * public List<String> binaryTreePaths(TreeNode root) {
    List<String> answer = new ArrayList<String>();
    if (root != null) searchBT(root, "", answer);
    return answer;
}
private void searchBT(TreeNode root, String path, List<String> answer) {
    if (root.left == null && root.right == null) answer.add(path + root.val);
    if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
    if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
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
class 257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        List<String>left, right;
        if ( root == null ) return new ArrayList<String>();
        if ( root.left == null && root.right == null )  { list.add(String.valueOf(root.val)); return list;}
        String tmp = root.val + "->";
        left = binaryTreePaths(root.left);
        for ( String i : left ) list.add(tmp.concat(i));
        right = binaryTreePaths(root.right);
        for ( String i : right ) list.add(tmp.concat(i));
        return list;
    }
}