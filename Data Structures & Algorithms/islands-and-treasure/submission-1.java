class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int inf = Integer.MAX_VALUE;
        int m = grid.length, n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) q.add(new int[]{i, j, 0});
            }
        }
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], v = cur[2];

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i], nc = c + dc[i];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != -1 && grid[nr][nc] == inf){
                    grid[nr][nc] = v + 1;
                    q.offer(new int[]{nr, nc, v + 1});
                } 
            }
        }
    }
    // public void islandsAndTreasure(int[][] grid) {
    //     int inf = Integer.MAX_VALUE;
    //     int m = grid.length, n = grid[0].length;

    //     boolean[][] vis = new boolean[m][n];
    //     for(int i = 0; i < m; i++){
    //         for(int j = 0; j < n; j++){
    //             if(grid[i][j] == inf && !vis[i][j]){
    //                 helper(grid, i, j, m, n, inf, vis);
    //             }
    //         }
    //     }
    // }

    // private int helper(int[][] grid, int i, int j, int m, int n, int inf, boolean[][] vis){
    //     if(i < 0 || i >= m || j < 0 || j >= n || vis[i][j] || grid[i][j] == -1) return inf;
    //     if(grid[i][j] == 0) return 0;
    //     vis[i][j] = true;
    //     int ans =    Math.min(helper(grid, i + 1, j, m, n, inf, vis),
    //                  Math.min(helper(grid, i - 1, j, m, n, inf, vis),
    //                  Math.min(helper(grid, i, j + 1, m, n, inf, vis),
    //                           helper(grid, i, j - 1, m, n, inf, vis))));
    //     if(ans != inf) grid[i][j] = Math.min(grid[i][j], 1 + ans);
    //     vis[i][j] = false;
    //     return grid[i][j];
    // }
}
