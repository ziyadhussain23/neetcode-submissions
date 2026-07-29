class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int cnt = helper(grid, i, j, m, n);
                    ans = Math.max(ans, cnt);
                }
            }
        }
        return ans;
    }

    private int helper(int[][] grid, int i, int j, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 0;

        grid[i][j] = 0;
        return 1 + helper(grid, i + 1, j, m, n)
                 + helper(grid, i - 1, j, m, n)
                 + helper(grid, i, j + 1, m, n)
                 + helper(grid, i, j - 1, m, n);
    }
}
