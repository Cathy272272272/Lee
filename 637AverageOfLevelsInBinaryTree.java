/*
 *BFS:

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            double sum = 0;
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            list.add(sum / count);
        }
        return list;
    }
DFS: a new node class make it more readable and professional

    class Node {
        double sum;
        int count;
        Node (double d, int c) {
            sum = d;
            count = c;
        }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Node> temp = new ArrayList<>();
        helper(root, temp, 0);
        List<Double> result = new LinkedList<>();
        for (int i = 0; i < temp.size(); i++) {
            result.add(temp.get(i).sum / temp.get(i).count);
        }
        return result;
    }
    public void helper(TreeNode root, List<Node> temp, int level) {
        if (root == null) return;
        if (level == temp.size()) {
            Node node = new Node((double)root.val, 1);
            temp.add(node);
        } else {
            temp.get(level).sum += root.val;
            temp.get(level).count++;
        }
        helper(root.left, temp, level + 1);
        helper(root.right, temp, level + 1);
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
class 637AverageOfLevelsInBinaryTree{
    List<List<Double>> depthCountSum = new ArrayList<List<Double>>();
    public List<Double> averageOfLevels(TreeNode root) {
        toTheEnd(root, 0);
        List<Double> out = new ArrayList<Double>();
        for ( List<Double> i : depthCountSum ){
            out.add((i.get(1)+ 0.0) / i.get(0));
        }
        return out;
    }
    public void toTheEnd(TreeNode root, int depth ){
        List<Double> temp = new ArrayList<Double>();
        TreeNode help;
        if ( root != null ){
            depth++;
            temp.clear();
            if (depthCountSum.size() < depth ){
                temp.add(1 + 0.0);
                temp.add(root.val + 0.0);
                depthCountSum.add(temp);
            }
            else{
                temp.add(depthCountSum.get(depth - 1).get(0) + 1);
                temp.add(depthCountSum.get(depth - 1).get(1) + root.val);
                depthCountSum.set(depth - 1, temp);
            }
            toTheEnd(root.right, depth);
            toTheEnd(root.left, depth);
        }
    }
}