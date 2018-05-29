Method 1.
This method also works for those who are not BSTs. The idea is to use a hashtable to save the values of the nodes in the BST. Each time when we insert the value of a new node into the hashtable, we check if the hashtable contains k - node.val.

Time Complexity: O(n), Space Complexity: O(n).

Java version:

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }
    
    public boolean dfs(TreeNode root, HashSet<Integer> set, int k){
        if(root == null)return false;
        if(set.contains(k - root.val))return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
C++ version:

    bool findTarget(TreeNode* root, int k) {
        unordered_set<int> set;
        return dfs(root, set, k);
    }
    
    bool dfs(TreeNode* root, unordered_set<int>& set, int k){
        if(root == NULL)return false;
        if(set.count(k - root->val))return true;
        set.insert(root->val);
        return dfs(root->left, set, k) || dfs(root->right, set, k);
    }
Method 2.
The idea is to use a sorted array to save the values of the nodes in the BST by using an inorder traversal. Then, we use two pointers which begins from the start and end of the array to find if there is a sum k.

Time Complexity: O(n), Space Complexity: O(n).

Java version:

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        for(int i = 0, j = nums.size()-1; i<j;){
            if(nums.get(i) + nums.get(j) == k)return true;
            if(nums.get(i) + nums.get(j) < k)i++;
            else j--;
        }
        return false;
    }
    
    public void inorder(TreeNode root, List<Integer> nums){
        if(root == null)return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
C++ version:

    bool findTarget(TreeNode* root, int k) {
        vector<int> nums;
        inorder(root, nums);
        for(int i = 0, j = nums.size()-1; i<j;){
            if(nums[i] + nums[j] == k)return true;
            (nums[i] + nums[j] < k)? i++ : j--;
        }
        return false;
    }
    
    void inorder(TreeNode* root, vector<int>& nums){
        if(root == NULL)return;
        inorder(root->left, nums);
        nums.push_back(root->val);
        inorder(root->right, nums);
    }
Method 3.
The idea is to use binary search method. For each node, we check if k - node.val exists in this BST.

Time Complexity: O(nlogn), Space Complexity: O(h). h is the height of the tree, which is logn at best case, and n at worst case.

Java version:

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root,  k);
    }
    
    public boolean dfs(TreeNode root,  TreeNode cur, int k){
        if(cur == null)return false;
        return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }
    
    public boolean search(TreeNode root, TreeNode cur, int value){
        if(root == null)return false;
        return (root.val == value) && (root != cur) 
            || (root.val < value) && search(root.right, cur, value) 
                || (root.val > value) && search(root.left, cur, value);
    }
C++ version:

    bool findTarget(TreeNode* root, int k) {
        return dfs(root, root,  k);
    }
    
    bool dfs(TreeNode* root,  TreeNode* cur, int k){
        if(cur == NULL)return false;
        return search(root, cur, k - cur->val) || dfs(root, cur->left, k) || dfs(root, cur->right, k);
    }
    
    bool search(TreeNode* root, TreeNode *cur, int value){
        if(root == NULL)return false;
        return (root->val == value) && (root != cur) 
            || (root->val < value) && search(root->right, cur, value) 
                || (root->val > value) && search(root->left, cur, value);
    }
    
    /** --------------------The below is not correct ( written by me......)-----------
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if ( root == null ) return false;
        //if ( k > root.val * 2 ) return findTarget(root.right, k);
        //else if ( k <= root.val ) return findTarget(root.left, k);
        int temp;
        if ( k == 2 * root.val ) {
            if ( root.right == null || root.left == null ) return false;
            return help(root.left, root.right, k);
            }
            return help(root.left, root, k) ;
                    //|| help(root.right, root, k));
        if (help(root.left, root.right, k)) return true;
        else {
            if ( root.left != null ) {
                temp = root.left.val;
                root.left.val = root.val;
                if ( help(root.left, root.right, k)) return true;
                else {
                    if ( root.right )
                }
            }
        }
        }
    public boolean find(TreeNode root, int k, int rootVal, TreeNode use) {
        if ( root == null ) return false;
        if ( root.val == k - rootVal) return true;
        if ( root.right == use ) return find(root.left, k, rootVal, use);
        else if ( root.left == use ) return find(root.right, k, rootVal, use);
        else return (find(root.left, k, rootVal, use) || find(root.right, k, rootVal, use));
    }
    public boolean help(TreeNode root, TreeNode use, int k) {
        if ( use!= null ) {
            if (find(root, k, use.val, use)) {
                return true;
            }
            else {
                return ( help(root, use.left, k) || help(root, use.right, k));
            }
        }
        else return false;
    }
}
-----------------The above is not correct--------------------------------- */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class 653TwoSumIV-InputIsaBST {
    public boolean findTarget(TreeNode root, int k) {
        if ( root == null ) return false;
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        for ( int i = 0; i < list.size(); i++ ) {
            for ( int j = i + 1; j < list.size(); j++ ) {
                if ( list.get(i) + list.get(j) == k )
                    return true;
            }
        }
    return false;
}
}

