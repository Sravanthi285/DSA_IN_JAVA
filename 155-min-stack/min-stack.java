class MinStack {
Stack<Integer> s = new Stack();
Stack<Integer> min;
    public MinStack() {
        min = new Stack();

        
    }
    
    public void push(int val) {
        s.push(val);
        if(min.isEmpty() || val <=min.peek()){
            min.push(val);
        }
        
    }
    
    public void pop() {
        int data = s.pop();
        if(min.peek()==data){
            min.pop();
        }
        
    }
    
    public int top() {
        return s.peek();
        
    }
    
    public int getMin() {
      return  min.peek();
        
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