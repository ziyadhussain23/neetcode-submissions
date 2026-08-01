class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O' && !vis[i][0]) helper(board, i, 0, m, n, vis);
            if(board[i][n - 1] == 'O' && !vis[i][n - 1]) helper(board, i, n - 1, m, n, vis);
        }
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O' && !vis[0][i]) helper(board, 0, i, m, n, vis);
            if(board[m - 1][i] == 'O' && !vis[m - 1][i]) helper(board, m - 1, i, m, n, vis);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!vis[i][j]) board[i][j] = 'X';
            }
        }
    }

    private void helper(char[][] board, int i, int j, int m, int n, boolean[][] vis){
        if(i < 0 || i >= m || j < 0 || j >= n || vis[i][j] || board[i][j] == 'X') return;

        vis[i][j] = true;
        helper(board, i + 1, j, m, n, vis);
        helper(board, i - 1, j, m, n, vis);
        helper(board, i, j + 1, m, n, vis);
        helper(board, i, j - 1, m, n, vis);
    }
}
