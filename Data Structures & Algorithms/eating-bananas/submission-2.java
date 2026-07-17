class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for(int i : piles) r = Math.max(r, i);
        int res = r;
        while(l <= r){
            int mid = (r - l) / 2 + l;
            long cur = check(piles, mid);
            if(cur <= h){
                res = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return res;

    }

    private long check(int[] arr, int k){
        long cnt = 0;
        for(int i : arr){
            cnt += Math.ceil((double)i / k); 
        }
        return cnt;
    }
}
