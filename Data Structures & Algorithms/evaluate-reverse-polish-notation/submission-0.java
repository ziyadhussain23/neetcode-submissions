class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(String s : tokens){
            char c = s.charAt(0);
            if(s.length() == 1 && (c == '+' || c == '-' || c == '*' || c == '/')){
                int a = st.pop();
                int b = st.pop();
                int ans = 0;
                if(c == '+') ans += (a + b);
                else if(c == '-') ans += (b - a);
                else if(c == '*') ans += (a * b);
                else if(c == '/') ans += (b / a);
                st.push(ans);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
