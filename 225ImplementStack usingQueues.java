/*
 * class MyStack 
{
    Queue<Integer> queue;
    
    public MyStack()
    {
        this.queue=new LinkedList<Integer>();
    }
    
    // Push element x onto stack.
    public void push(int x) 
    {
       queue.add(x);
       for(int i=0;i<queue.size()-1;i++)
       {
           queue.add(queue.poll());
       }
    }

    // Removes the element on top of the stack.
    public void pop() 
    {
        queue.poll();
    }

    // Get the top element.
    public int top() 
    {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() 
    {
        return queue.isEmpty();
    }
}
*/
class MyStack {
    Queue<Integer> q;
    Queue<Integer> p;
    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<Integer>();
        p = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if ( q.size() == 0 ) p.offer(x);
        else q.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if ( q.size() == 0 ) {
            while ( p.size() > 1 ) q.offer(p.poll());
            return p.poll();
        }
        else {
            while ( q.size() > 1 ) p.offer(q.poll());
            return q.poll();            
        }
    }
    
    /** Get the top element. */
    public int top() {
        int tmp;
        if ( q.size() == 0 ) {
            while ( p.size() > 1 ) q.offer(p.poll());
            tmp = p.poll();
            q.offer(tmp);
        }
        else {
            while ( q.size() > 1 ) p.offer(q.poll());
            tmp = q.poll(); 
            p.offer(tmp);
        } 
        return tmp;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return ( p.size() == 0 && q.size() == 0 );
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */