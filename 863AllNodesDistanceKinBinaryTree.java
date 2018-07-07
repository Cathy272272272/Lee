/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 863AllNodesDistanceKinBinaryTree {
    List<Integer> list = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if ( root == null ) return list;
        if ( K == 0 ) {
            list.add(target.val);
            return list;
        }
        add(target, K);
        List<TreeNode> trace = new ArrayList<TreeNode>();
        List<Integer> lr = new ArrayList<Integer>();
        if ( !equal(root, target) ) {
            find(root, target, K, trace, lr);
        }
        return list;
    }
    public void find(TreeNode root, TreeNode tar, int K, List<TreeNode> t, List<Integer> lr) {
        if ( root == null ) return;
        if ( equal(root, tar)) {
            int i = t.size() - 1;
            int j = lr.size() - 1;
            if ( K == 0 ) {
                add(root, 0);
                return;
            }
            while ( K > 1 ) {
                K--;
                if ( i < 0 ) return;
                if ( lr.get(j) == 0 )
                    add(t.get(i).right, K - 1);
                else add(t.get(i).left, K - 1);
                i--;
                j--;
            }
            if ( i >= 0 ) {
                add(t.get(i), 0);
                return;
            }
            return;
        }
        t.add(root);
        List<Integer> l = new ArrayList<Integer>(lr);
        List<Integer> r = new ArrayList<Integer>(lr);
        l.add(0);
        find(root.left, tar, K, new ArrayList<TreeNode>(t), l);
        r.add(1);
        find(root.right, tar, K, new ArrayList<TreeNode>(t), r); 
    }
    public void add(TreeNode root, int K) {
        if ( root == null ) return;
        if ( K == 0 ) {
            list.add(root.val);
            return;
        }
        add(root.left, K-1);
        add(root.right, K-1);
    }
    public boolean equal(TreeNode p, TreeNode q) {
        if ( p == null && q == null ) return true;
        if ( p == null || q == null ) return false;
        if ( p.val != q.val ) return false;
        return equal(p.left, q.left) && equal(p.right, q.right);
    }
}