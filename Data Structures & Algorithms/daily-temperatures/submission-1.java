class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] res = new int[n];
        Stack<int[]> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            if(st.isEmpty()){
                res[i] = 0;
            }else{
                while(!st.isEmpty() && st.peek()[0] <= t[i]) st.pop();
                if(!st.isEmpty()) res[i] = st.peek()[1] - i;
                else res[i] = 0;
            }
            st.push(new int[]{t[i], i});
        }
        return res;
    }
}
