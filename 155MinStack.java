/*
 * The question is ask to construct One stack. So I am using one stack.

The idea is to store the gap between the min value and the current value;

The problem for my solution is the cast. I have no idea to avoid the cast. Since the possible gap between the current value and the min value could be Integer.MAX_VALUE-Integer.MIN_VALUE;

public class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack(){
        stack=new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else{
            stack.push(x-min);//Could be negative if min value needs to change
            if (x<min) min=x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        
        long pop=stack.pop();
        
        if (pop<0)  min=min-pop;//If negative, increase the min value
        
    }

    public int top() {
        long top=stack.peek();
        if (top>0){
            return (int)(top+min);
        }else{
           return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }
}
*/
class MinStack {
    PriorityQueue<Integer> pq;
    Stack stack;
    /** initialize your data structure here. */
    public MinStack() {
        pq = new PriorityQueue<Integer>();
        stack = new Stack();
    }
    
    public void push(int x) {
        pq.offer(x);
        stack.push(x);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return (int)stack.peek();
    }
    
    public int getMin() {
        while ( !stack.contains(pq.peek()) ) pq.poll();
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */