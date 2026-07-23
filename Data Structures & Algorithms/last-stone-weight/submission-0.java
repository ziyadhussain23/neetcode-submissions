class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i : stones) pq.offer(i);

        while(!pq.isEmpty()){
            int x = pq.poll();
            if(pq.isEmpty()) return x;
            int y = pq.poll();

            if(x == y) continue;
            pq.offer(Math.abs(x - y));
        }
        return 0;
    }
}
