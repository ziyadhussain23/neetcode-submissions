class Solution {
    public int orangesRotting(int[][] grid) {
        int cnt = 0, m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j, 0});
                }else if(grid[i][j] == 1) cnt++;
            }
        }

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], t = cur[2];

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i], nc = c + dc[i];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    cnt--;
                    if(cnt == 0) return t + 1;
                    q.offer(new int[]{nr, nc, t + 1});
                }
            }
        }

        return cnt == 0 ? 0 : -1;
    }
}
