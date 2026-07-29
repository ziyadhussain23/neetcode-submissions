class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0, m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    helper(grid, i, j, m, n);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void helper(char[][] grid, int i, int j, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;

        grid[i][j] = '0';
        helper(grid, i + 1, j, m, n);
        helper(grid, i - 1, j, m, n);
        helper(grid, i, j + 1, m, n);
        helper(grid, i, j - 1, m, n);
    }

}
