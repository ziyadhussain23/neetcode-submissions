class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis = new boolean[n], path = new boolean[n];
        if(helper(adj, 0, n, vis)) return false;
        for(boolean v : vis) if(!v) return false;
        return true;
    }

    private boolean helper(List<List<Integer>> adj, int node, int p, boolean[] vis){
        vis[node] = true;
        for(int nei : adj.get(node)){
            if(nei == p) continue;
            if(vis[nei]) return true;
            if(helper(adj, nei, node, vis));
        }
        return false;
    }
}
