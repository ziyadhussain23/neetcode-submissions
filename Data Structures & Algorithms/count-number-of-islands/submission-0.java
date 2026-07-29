class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0, m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    helper(grid, i, j, m, n, vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void helper(char[][] grid, int i, int j, int m, int n, boolean[][] vis){
        if(i < 0 || i >= m || j < 0 || j >= n || vis[i][j] || grid[i][j] == '0') return;

        vis[i][j] = true;
        helper(grid, i + 1, j, m, n, vis);
        helper(grid, i - 1, j, m, n, vis);
        helper(grid, i, j + 1, m, n, vis);
        helper(grid, i, j - 1, m, n, vis);
    }

}
