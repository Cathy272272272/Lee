/* wtf...... so easy...... can use 2*i and 2*i + 1 to represent left and right
 * We know that a binary tree can be represented by an array (assume the root begins from the position with index 1 in the array). If the index of a node is i, the indices of its two children are 2*i and 2*i + 1. The idea is to use two arrays (start[] and end[]) to record the the indices of the leftmost node and rightmost node in each level, respectively. For each level of the tree, the width is end[level] - start[level] + 1. Then, we just need to find the maximum width.

Java version:

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }
    
    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        if(start.size() == level){
            start.add(order); end.add(order);
        }
        else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
C++ version (use vector<pair<int,int>> to replace the arrays start and end in Java ):

   int widthOfBinaryTree(TreeNode* root) {
        return dfs(root, 0, 1, vector<pair<int, int>>() = {});
    }
    
    int dfs(TreeNode* root, int level, int order, vector<pair<int, int>>& vec){
        if(root == NULL)return 0;
        if(vec.size() == level)vec.push_back({order, order});
        else vec[level].second = order;
        return max({vec[level].second - vec[level].first + 1, dfs(root->left, level + 1, 2*order, vec), dfs(root->right, level + 1, 2*order + 1, vec)});
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
class 662MaximumWidthofBinaryTree {
    Map<Integer, Integer> left = new HashMap<Integer, Integer>();
    Map<Integer, Integer> right = new HashMap<Integer, Integer>();    
    public int widthOfBinaryTree(TreeNode root) {
        if ( root == null ) return 0;
        if (root.left == null && root.right == null ) {
            return 1;
        }
        TreeNode tmp, help;
        if ( root.left != null && root.right != null ) tmp = root;
        else {
            //System.out.println("haha");
            if ( root.left == null ) tmp = root.right;
            else tmp = root.left;
            while ( tmp != null ) {
                if ( tmp.left != null && tmp.right != null ) break;
                if ( tmp.left == null && tmp.right == null ) return 1;
                if ( tmp.left == null ) tmp = tmp.right;
                else tmp = tmp.left;
            }
        }
        if ( tmp != null ) {
            left.put(1, 1);
            right.put(1, 1);
            left(tmp.left, 1);
            right(tmp.right, 1);
        }
        int min;
        if ( left.size() > right.size() ) {
            min = right.size();
            help = tmp.left;
        }
        else {
            min = left.size();
            help = tmp.right;
        }
        int max = 0;
        for ( int i = 1; i <= min; i++ ) {
            max = Math.max(max, left.get(i) + right.get(i));
        }
        left.clear();
        right.clear();
        return Math.max(max, widthOfBinaryTree(help));
    }
    public void left(TreeNode root, int depth) {
        if ( root.left == null && root.right == null ) return;
        if ( root.right != null ) {
            left.put(depth + 1, left.get(depth) * 2 - 1);
            left(root.right, depth + 1);
        }
        if ( root.left != null) {
            left.put(depth + 1, left.get(depth) * 2);
            left(root.left, depth + 1);
        }
    }
    public void right(TreeNode root, int depth) {
        if ( root.left == null && root.right == null ) return;
        if ( root.left != null ) {
            right.put(depth + 1, right.get(depth) * 2 - 1);
            right(root.left, depth + 1);
        }
        if ( root.right != null) {
            right.put(depth + 1, right.get(depth) * 2);
            right(root.right, depth + 1);
        }
    }    
}