class 455AssignCookies {
    /*public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0, mark = 0;
        for ( int i : s ) {
            for ( int j = mark; j < g.length; j++ ) {
                if ( i >= g[j] ) {
                    count++;
                    mark = j + 1;
                    break;
                }
            }
        }
        return count;
    }*/
   public ListNode reverseList(ListNode head) {
        if ( head == null ) return null;
        if ( head.next == null ) return head;
        return reverse(head, null);
    }
    public ListNode reverse(ListNode head, ListNode prev ) {
        if ( head.next == null ) {
            head.next = prev;
            return head;
        }
        else {
            ListNode help = head;
            head = head.next;
            help.next = prev;
            prev = help;
            return reverse(head, prev);
        }
    }
}