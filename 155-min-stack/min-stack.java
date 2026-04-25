class MinStack {
    Stack<Integer> stk;
    Stack<Integer> minStk;
    public MinStack() {
        stk=new Stack<>();
        minStk=new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(minStk.isEmpty())
            minStk.push(val);
        else
            minStk.push(Math.min(minStk.peek(),val));
    }
    
    public void pop() {
        stk.pop();
        minStk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */