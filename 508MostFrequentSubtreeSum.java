/*
 * public class Solution {
    Map<Integer, Integer> sumToCount;
    int maxCount;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        maxCount = 0;
        sumToCount = new HashMap<Integer, Integer>();
        
        postOrder(root);
        
        List<Integer> res = new ArrayList<>();
        for (int key : sumToCount.keySet()) {
            if (sumToCount.get(key) == maxCount) {
                res.add(key);
            }
        }
        
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    
    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        
        int sum = left + right + root.val;
        int count = sumToCount.getOrDefault(sum, 0) + 1;
        sumToCount.put(sum, count);
        
        maxCount = Math.max(maxCount, count);
        
        return sum;
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
class 508MostFrequentSubtreeSum {
    List<Integer> result = new ArrayList<Integer>();
    public int[] findFrequentTreeSum(TreeNode root) {
        int mark = -1;
        int max = 1;
        int count = 1;
        int maxNumber = 1;
        int j = 0;
        collectSum(root);
        Collections.sort(result);
        if ( result.size() == 0) {
            int[] out = new int[0];
           return out;
        }
        if ( result.size() == 1 ) {
            int[] out = new int[1];
            out[0] = result.get(0);
            return out;
        } 
        List<Integer> help = new ArrayList<Integer>();
        for (int i = 1; i < result.size(); i++)
            help.add(result.get(i) - result.get(i-1));
        for ( int i = 0; i < help.size(); i++ ){
            if ( help.get(i) != 0 ){
                if ( max == i - mark )
                    maxNumber++;
                if ( max < i - mark ){
                    max = i - mark;
                    maxNumber = 1;
                }
                mark = i;
            }
        }
        if ( help.size() - mark == max && help.get(help.size()-1) == 0) 
            maxNumber++;
        if ( help.size() - mark > max && help.get(help.size()-1) == 0)  {
            max = help.size() - mark;
            maxNumber = 1;
        }
        int[] out = new int[maxNumber];
        if ( result.get(1) != result.get(0) && max == 1 ) { out[0] = result.get(0); j = 1;}
       for (int i = 1; i < result.size(); i++){
            if ((int)(result.get(i)) == (int) result.get(i - 1)){
                count++;
            }
           else count = 1;
           if ( count == max ){
               out[j] = result.get(i);
               j++;
           }
       }
        return out;
    }
    public int sum(TreeNode root){
        if ( root == null ) return 0; 
        return ( root.val + sum(root.left) + sum(root.right));
    }
    public void collectSum(TreeNode root) {
       if ( root != null ){
        result.add(sum(root));
        collectSum(root.left);
        collectSum(root.right);
       }
    }
}