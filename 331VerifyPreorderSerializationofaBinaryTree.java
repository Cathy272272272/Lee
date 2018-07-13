/*
 * See detailed comments below. Time complexity is O(n), space is also O(n) for the stack.

public class Solution {
    public boolean isValidSerialization(String preorder) {
        // using a stack, scan left to right
        // case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
        if (preorder == null) {
            return false;
        }
        Stack<String> st = new Stack<>();
        String[] strs = preorder.split(",");
        for (int pos = 0; pos < strs.length; pos++) {
            String curr = strs[pos];
            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
                st.pop();
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
            st.push(curr);
        }
        return st.size() == 1 && st.peek().equals("#");
    }
}
*/

/*
 * Some used stack. Some used the depth of a stack. Here I use a different perspective. In a binary tree, if we consider null as leaves, then

all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
Suppose we try to build this tree. During building, we record the difference between out degree and in degree diff = outdegree - indegree. When the next node comes, we then decrease diff by 1, because the node provides an in degree. If the node is not null, we increase diff by 2, because it provides two out degrees. If a serialization is correct, diff should never be negative and diff will be zero when finished.

public boolean isValidSerialization(String preorder) {
    String[] nodes = preorder.split(",");
    int diff = 1;
    for (String node: nodes) {
        if (--diff < 0) return false;
        if (!node.equals("#")) diff += 2;
    }
    return diff == 0;
}
*/
class 331VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        if ( preorder.length() == 0 ) return false;
        String[] node = preorder.split(",");
        List<String> list = new ArrayList<String>();
        for (String i : node ) list.add(i);
        Stack<String> stack = new Stack<>();
        while ( list.size() != 1 ) {
            System.out.println(list + " " + stack );
            int n = list.size() - 1;
            if ( n < 1 ) return false;
            if ( !list.get(n).equals("#") ) return false;
            if ( !list.get(n-1).equals("#") ) {
                if ( stack.empty() ) return false;
                list.add(stack.pop());
                continue;
            }
            if ( n - 2 < 0 ) return false;
            if ( !list.get(n-2).equals("#") ) {
                list.remove(n);
                list.remove(n-1);
                list.set(n-2, "#");
                continue;
            }
            else {
                stack.push("#");
                list.remove(n);
            }
        }
        return list.get(0).equals("#") && stack.empty();
    }
}