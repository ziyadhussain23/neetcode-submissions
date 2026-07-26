class MedianFinder {
    Queue<Integer> pq, pq2;

    public MedianFinder() {
        pq = new PriorityQueue<>((a, b) -> b - a);
        pq2 = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        pq.offer(num);
        pq2.offer(pq.poll());

        if(pq2.size() > pq.size()){
            pq.offer(pq2.poll());
        }
    }
    
    public double findMedian() {
        if((pq.size() + pq2.size()) % 2 == 0) return (pq.peek() + pq2.peek()) / 2.0;
        return pq.peek();
    }
}
