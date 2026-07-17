class Solution {
    public int trap(int[] height) {
        int ans = 0, n = height.length;
        int l = 0, r = n - 1;
        int left = height[l], right = height[r];
        while(l < r){
            if(left < right){
                l++;
                left = Math.max(left, height[l]);
                ans += left - height[l];
            }else{
                r--;
                right = Math.max(right, height[r]);
                ans += right - height[r];
            }
        }
        return ans;
    }


    // public int trap(int[] height) {
    //     int ans = 0, n = height.length;
    //     int[] pre = new int[n];
    //     int[] suf = new int[n];
    //     pre[0] = height[0];
    //     suf[n - 1] = height[n - 1];
    //     for(int i = 1; i < n; i++){
    //         pre[i] = Math.max(pre[i - 1], height[i]);
    //         suf[n - i - 1] = Math.max(suf[n - i], height[n - i - 1]);
    //     }
    //     for(int i = 0; i < n; i++){
    //         ans += Math.min(suf[i], pre[i]) - height[i];
    //     }
    //     return ans;
    // }
}
