class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Stack<int[]> st = new Stack<>();
        for(int i = 0; i < n; i++){
            int start = i;
            while(!st.isEmpty() && st.peek()[1] > heights[i]){
                int[] arr = st.pop();
                max = Math.max(max, arr[1] * (i - arr[0]));
                start = arr[0];
            }
            st.push(new int[]{start, heights[i]});
        }
        for(int[] a : st){
            max = Math.max(max, a[1] * (n - a[0]));
        }
        return max;
    }
}
