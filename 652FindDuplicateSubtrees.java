//https://leetcode.com/problems/find-duplicate-subtrees/discuss/106016/O(n)-time-and-space-lots-of-analysis
/*
 * public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> res = new LinkedList<>();
    postorder(root, new HashMap<>(), res);
    return res;
}

public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
    if (cur == null) return "#";  
    String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
    if (map.getOrDefault(serial, 0) == 1) res.add(cur);
    map.put(serial, map.getOrDefault(serial, 0) + 1);
    return serial;
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
class 652FindDuplicateSubtrees {
    List<TreeNode> list = new ArrayList<TreeNode>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if ( root == null ) return list;
        haha(root);
        return list;
    }
    public void haha(TreeNode root) {
        if ( root == null ) return;
        help(root.left, root.right);
        haha(root.left);
        haha(root.right);
    }
    public void help(TreeNode root, TreeNode cmp) {
        if ( root == null ) return;
        find(root, cmp);
        help(root.left, cmp);
        help(root.right, cmp);
    }
    public void find(TreeNode root, TreeNode cmp) {
        if ( cmp == null || root == null ) return;
        if ( equal(root, cmp) ) {
            boolean check = false;
            for ( TreeNode i : list ) {
                if ( equal(i, root)) {
                    check = true;
                    break;
                }
            }
            if ( !check ) list.add(root);
            /*find(root.left, cmp.left);
            find(root.right, cmp.right);
            return;*/
        }
        //else {
            find(root, cmp.left);
            find(root, cmp.right);
        //}
    }
    
    public boolean equal(TreeNode p, TreeNode q ) {
        if ( p == null && q == null ) return true;
        if ( p == null || q == null ) return false;
        if ( p.val != q.val ) return false;
        return equal(p.left, q.left) && equal(p.right, q.right);
    }
}