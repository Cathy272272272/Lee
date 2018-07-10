/*
 * I've seen several solutions claimed to be O(1) space, but I disagree. They traverse the tree in in-order and keep track of the current set of modes (among other things). But that's not O(1) space, not even when disregarding recursion stack space (as explicitly allowed) and result space (not mentioned but reasonable). The set's contents aren't on stack space, so it can't be disregarded that way. And if the values are for example 1,2,3,4,...,n-2,n-1,n-1 (unique values followed by one double value), the set grows to ¦¸(n) and it can't be disregarded because the result only has size 1.

I think the way to do it properly is to do two passes. One to find the highest number of occurrences of any value, and then a second pass to collect all values occurring that often. Any other ideas?

Here's a (two-pass) solution that I think can rightfully be called O(1) space. Both passes keep track of the current value etc, and the second pass additionally collects the modes in the result array. I took the value handling out of the in-order traversal into its own function for clarity. Also, this way you could very easily replace my recursive in-order traversal with for example Morris traversal. Then you wouldn't even need to disregard the recursion stack space in order to claim O(1) extra space usage.

public class Solution {
    
    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
    }

    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;
    
    private int[] modes;

    private void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null)
                modes[modeCount] = currVal;
            modeCount++;
        }
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }
}
Edit: Here's Morris traversal, just replace my previous inorder function with this. I hadn't realized it earlier, but having my separate handleValue function doesn't just nicely separate the traversal logic from this problem's logic, but it's also beneficial for Morris traversal because I'm calling handleValue from two different places in the code!

    private void inorder(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                handleValue(node.val);
                node = node.right;
            } else {
                TreeNode prev = node.left;
                while (prev.right != null && prev.right != node)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    prev.right = null;
                    handleValue(node.val);
                    node = node.right;
                }
            }
        }
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
class 501FindModeinBinarySearchTree {
    public int[] findMode(TreeNode root) {
        if ( root == null ) return new int[0];
        List<Integer> list = find(root);
        list.remove(0);
        int size = list.size();
        int[] ans = new int[size];
        for ( int i = 0; i < size; i++ ) ans[i] = list.get(i); 
        return ans;
    }
    public int help(TreeNode root, int val) {
        if ( root == null ) return 0;
        int count = 0;
        if ( root.val == val ) count++;
        return count + help(root.left, val) + help(root.right, val);
    }
    public List<Integer> find(TreeNode root) {
        if ( root == null ) return new ArrayList<Integer>();
        int cur = help(root, root.val);
        List<Integer> l = find(root.left);
        List<Integer> r = find(root.right);
        if ( l.size() == 0 && r.size() == 0 ) {
            l.add(1);
            l.add(root.val);
            return l;
        }
        int lcount = 0, rcount = 0;
        if (l.size() != 0 ) {
            lcount = l.get(0);
            l.remove(0);
        }
        if (r.size() != 0 ) {
            rcount = r.get(0);
            r.remove(0);
        }
        if ( l.contains(root.val) && r.contains(root.val) ) {
            l.clear();
            l.add(cur);
            l.add(root.val);
            return l;
        }
        else if ( l.contains(root.val) ) {
            if ( cur > rcount ) {
                l.clear();
                l.add(cur);
                l.add(root.val);
                return l;                
            }
            else if ( cur < rcount ) {
                r.add(0, rcount);
                return r;
            }
            else {
                r.add(0, cur);
                r.add(root.val);
                return r;
            }
        }
        else if ( r.contains(root.val) ) {
            if ( cur > lcount ) {
                l.clear();
                l.add(cur);
                l.add(root.val);
                return l;                
            }
            else if ( cur < lcount ) {
                l.add(0, lcount);
                return l;
            }
            else {
                l.add(0, cur);
                l.add(root.val);
                return l;
            }            
        }
        else {
            List<Integer> tmp;
            int max = 0;
            if ( lcount > rcount ) {
                tmp = l;
                max = lcount;
            }
            else if (lcount < rcount) {
                tmp = r;
                max = rcount;
            }
            else {
                l.addAll(r);
                tmp = l;
                max = lcount;
            }
            if ( cur > max ) {
                l.clear();
                l.add(cur);
                l.add(root.val);
                return l;                  
            }
            else if ( cur < max ) {
                tmp.add(0, max);
                return tmp;
            }
            else {
                tmp.add(0, max);
                tmp.add(root.val);
                return tmp;
            }
        }
    }
}