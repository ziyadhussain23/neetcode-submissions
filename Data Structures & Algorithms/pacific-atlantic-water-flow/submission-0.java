class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for(int i = 0; i < n; i++){
            helper(0, i, pac, heights);
            helper(m - 1, i, atl, heights);
        }
        for(int i = 0; i < m; i++){
            helper(i, 0, pac, heights);
            helper(i, n - 1, atl, heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void helper(int r, int c, boolean[][] ocean, int[][] heights){
        ocean[r][c] = true;
        for(int[] d: directions){
            int nr = r + d[0], nc = c + d[1];
            if(nr >= 0 && nr < heights.length &&
               nc >= 0 && nc < heights[0].length &&
               !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                helper(nr, nc, ocean, heights);
               }
        }
    }
}
