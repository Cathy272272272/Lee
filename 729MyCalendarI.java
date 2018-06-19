class 729MyCalendarI {
    List<List<Integer>> list;
    public MyCalendar() {
        list = new ArrayList<List<Integer>>();
    }
    
    public boolean book(int start, int end) {
        List<Integer> tmp = new ArrayList<Integer>();
        if ( list.isEmpty() ) {
            tmp.add(start);
            tmp.add(end);
            list.add(tmp);
            return true;
        }
        for (List<Integer> i : list) {
            if ( (i.get(1) > start && i.get(0) <= start) || ( end > i.get(0) && end <= i.get(1)) || (start <= i.get(0) && end >= i.get(1) )) return false;
        }
        tmp.add(start);
        tmp.add(end);
        list.add(tmp);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */