class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> euclidean(a[0], 0, a[1], 0)));
        for(int[] p: points) pq.offer(p);

        int[][] arr = new int[k][2];
        for(int i = 0; i < k; i++){
            arr[i] = pq.poll();
        }
        return arr;
    }

    private double euclidean(int x1, int x2, int y1, int y2){
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
