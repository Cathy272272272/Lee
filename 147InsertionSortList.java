https://leetcode.com/problems/insertion-sort-list/discuss/46429/Thoughts-from-a-Google-interviewer
/*
 * 
Last Edit: July 16, 2018 8:26 PM

sbvictory
sbvictory
 254
public ListNode insertionSortList(ListNode head) {
  if( head == null ){
   return head;
  }
  
  ListNode helper = new ListNode(0); //new starter of the sorted list
  ListNode cur = head; //the node will be inserted
  ListNode pre = helper; //insert node between pre and pre.next
  ListNode next = null; //the next node will be inserted
  //not the end of input list
  while( cur != null ){
   next = cur.next;
   //find the right place to insert
   while( pre.next != null && pre.next.val < cur.val ){
    pre = pre.next;
   }
   //insert between pre and pre.next
   cur.next = pre.next;
   pre.next = cur;
   pre = helper;
   cur = next;
  }
  
  return helper.next;
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
class 147InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if ( head == null ) return null;
        ListNode cur = head.next;
        ListNode prev = head;
        while ( cur != null ) {
            int val = cur.val;
            ListNode help = head;
            ListNode helpprev = null;
            while ( help != cur ) {
                if ( help.val > val ) {
                    if ( help == head ) {
                        ListNode newHead = new ListNode(val);
                        newHead.next = head;
                        head = newHead;
                        prev.next = cur.next;
                        cur = cur.next;
                        break;
                    }
                    else {
                        ListNode newNode = new ListNode(val);
                        newNode.next = help;
                        helpprev.next = newNode;
                        prev.next = cur.next;
                        cur = cur.next;
                        break;                        
                    }
                }
                helpprev = help;
                help = help.next;
            }
            if ( help == cur ) {
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}