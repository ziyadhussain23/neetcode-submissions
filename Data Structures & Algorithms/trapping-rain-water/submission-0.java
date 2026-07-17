class Solution {
    public int trap(int[] height) {
        int ans = 0, n = height.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = height[0];
        suf[n - 1] = height[n - 1];
        for(int i = 1; i < n; i++){
            pre[i] = Math.max(pre[i - 1], height[i]);
            suf[n - i - 1] = Math.max(suf[n - i], height[n - i - 1]);
        }
        for(int i = 0; i < n; i++){
            ans += Math.min(suf[i], pre[i]) - height[i];
        }
        return ans;
    }
}
