class MinStack {
    Stack<Integer> st;
    Stack<Integer> st2;
    public MinStack() {
        st = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        st2.push(Math.min(val, st2.isEmpty() ? Integer.MAX_VALUE: st2.peek()));
    }
    
    public void pop() {
        st.pop();
        st2.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return st2.peek();
    }
}
