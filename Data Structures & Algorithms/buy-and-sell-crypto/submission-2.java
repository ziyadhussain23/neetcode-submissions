class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0];
        for(int i : prices){
            ans = Math.max(ans, i - min);
            min = Math.min(min, i);
        }
        return ans;
    }


    // public int maxProfit(int[] prices) {
    //     int l = 0, r = 1;
    //     int ans = 0;
    //     while(r < prices.length){
    //         if(prices[l] < prices[r]){
    //             ans = Math.max(ans, prices[r] - prices[l]);
    //         }else l = r;
    //         r++;
    //     }
    //     return ans;
    // }
}
