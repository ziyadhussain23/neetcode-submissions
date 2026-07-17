class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = nums.length;
        int[] cnt = new int[20001];
        for(int i = 0; i < k - 1; i++){
            pq.offer(nums[i]);
            cnt[10000 + nums[i]]++;
        }
        int[] res = new int[n - k + 1];
        int l = 0, r = k - 1;
        while(r < n){
            pq.offer(nums[r]);
            cnt[10000 + nums[r]]++;
            r++;
            while(cnt[10000 + pq.peek()] == 0) pq.poll();
            cnt[10000 + nums[l]]--;
            res[l++] = pq.peek();
        }
        return res;
    }
}
