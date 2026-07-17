// class Solution {
//     public int evalRPN(String[] tokens) {
//         Stack<Integer> st = new Stack<>();
        
//         for(String s : tokens){
//             char c = s.charAt(0);
//             if(s.length() == 1 && (c == '+' || c == '-' || c == '*' || c == '/')){
//                 int a = st.pop();
//                 int b = st.pop();
//                 int ans = 0;
//                 if(c == '+') ans += (a + b);
//                 else if(c == '-') ans += (b - a);
//                 else if(c == '*') ans += (a * b);
//                 else if(c == '/') ans += (b / a);
//                 st.push(ans);
//             }else{
//                 st.push(Integer.parseInt(s));
//             }
//         }
//         return st.pop();
//     }
// }

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(String s : tokens){
            char c = s.charAt(0);
            if(s.equals("+")){
                st.push(st.pop() + st.pop());
            }else if(s.equals("*")){
                st.push(st.pop() * st.pop());
            }else if(s.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            }else if(s.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}

