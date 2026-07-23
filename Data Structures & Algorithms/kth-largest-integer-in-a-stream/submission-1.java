class KthLargest {
    int k;
    Queue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>((a, b) -> a - b);
        for(int i = 0; i < nums.length; i++){
            if(pq.size() == k){
                if(pq.peek() < nums[i]){
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }else
                pq.offer(nums[i]);
        }
    }

    public int add(int val) {
        if(pq.size() == k){
            if(pq.peek() < val){
                pq.poll();
                pq.offer(val);
            }
        }else
            pq.offer(val);
        return pq.peek();
    }
}
