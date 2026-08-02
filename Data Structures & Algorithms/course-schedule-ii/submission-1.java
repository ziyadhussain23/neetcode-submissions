class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] p : pre){
            adj.get(p[1]).add(p[0]);
        }
        List<Integer> ans = new ArrayList<>();
        boolean[] path = new boolean[n];
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i] && helper(i, n, adj, vis, path, ans)) return new int[0];
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = ans.get(n - i - 1);
        }
        return res;
    }

    private boolean helper(int i, int n, List<List<Integer>> adj, boolean[] vis,
                           boolean[] path,  List<Integer> ans){

        vis[i] = true;
        path[i] = true;
        for(int n1 : adj.get(i)){
            if(!vis[n1]){ if(helper(n1, n, adj, vis, path, ans)) return true;}
            else if(path[n1]) return true;
        }
        path[i] = false;
        ans.add(i);
        return false;
    }
    
}
