class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] p: pre) adj.get(p[0]).add(p[1]);
        boolean[] vis = new boolean[n], path = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i] && helper(adj, i, vis, path)) return false;
        }
        return true;
    }

    private boolean helper(List<List<Integer>> adj, int node, boolean[] vis, boolean[] path){
        vis[node] = true;
        path[node] = true;
        for(int nei : adj.get(node)){
            if(!vis[nei] && helper(adj, nei, vis, path)) return true;
            else if(path[nei]) return true;
        }
        path[node] = false;
        return false;
    }
}
