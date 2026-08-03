class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] ind = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            ind[u]++;
            ind[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) if(ind[i] == 1) q.offer(i);

        while(!q.isEmpty()){
            int node = q.poll();
            ind[node]--;
            for(int nei: adj.get(node)){
                ind[nei]--;
                if(ind[nei] == 1) q.offer(nei);
            }
        }

        for(int i = n - 1; i >= 0; i--){
            int u = edges[i][0], v = edges[i][1];
            if(ind[u] == 2 && ind[v] > 0) return new int[]{u, v};
        }
        return new int[0];
    }

}
