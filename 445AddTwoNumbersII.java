/*
 * public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }
        
        return list.val == 0 ? list.next : list;
    }
}
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class 445AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l;
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> ss, ll;
        int s1 = 0, s2 = 0;
        ListNode tmp1 = l1;
        while ( tmp1 != null ) {
            list1.add(tmp1.val);
            tmp1 = tmp1.next;
            s1++;
        }
        ListNode tmp2 = l2;
        while ( tmp2 != null ) {
            list2.add(tmp2.val);
            tmp2 = tmp2.next;
            s2++;
        }
        int small, large;
        if ( s1 > s2 || (s1 == s2 && list1.get(0) > list2.get(0) )) {
            l = l1;
            ss = list2;
            ll = list1;
            small = s2;
            large = s1;
        }
        else {
            l = l2;
            ss = list1;
            ll = list2;
            small = s1;
            large = s2;
        }
        int index = 0, carry = 0, sum;
        while ( small > 0 ) {
                sum = ss.get(small - 1) + ll.get(large - 1) + carry;
                small--;
            if ( sum < 10 ) {
                list.add(0, sum);
                carry = 0;
            }
            else {
                list.add(0, sum%10);
                carry = 1;
            }
            index++;
            large--;
        }
        System.out.println(large);
        while ( large > 0 ) {
            sum = ll.get(large - 1) + carry;
            if ( sum < 10 ) {
                list.add(0, sum);
                carry = 0;
            }
            else {
                list.add(0, sum%10);
                carry = 1;
            }
            large--;
        }
        if ( carry == 1 ) list.add(0,1);
        ListNode res = new ListNode(list.get(0));
        ListNode head = res;
        for ( int i = 1; i < list.size(); i++ ) {
            ListNode tmp = new ListNode(list.get(i));
            res.next = tmp;
            res = res.next;
        }
        return head;
    }
}