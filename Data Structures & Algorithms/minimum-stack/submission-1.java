// class MinStack {
//     Stack<Integer> st;
//     Stack<Integer> st2;
//     public MinStack() {
//         st = new Stack<>();
//         st2 = new Stack<>();
//     }
    
//     public void push(int val) {
//         st.push(val);
//         st2.push(Math.min(val, st2.isEmpty() ? Integer.MAX_VALUE: st2.peek()));
//     }
    
//     public void pop() {
//         st.pop();
//         st2.pop();
//     }
    
//     public int top() {
//         return st.peek();
//     }
    
//     public int getMin() {
//         return st2.peek();
//     }
// }
class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(0L);
            min = val;
        }else{
            st.push(val - min);
            if(val - min < 0) min = val;
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;

        long pop = st.pop();
        if(pop < 0) min = min - pop;
    }
    
    public int top() {
        long top = st.peek();
        if(top > 0){
            return (int) (top + min);
        }else{
            return (int) min;
        }
    }
    
    
    public int getMin() {
        return (int) min;
    }
}
