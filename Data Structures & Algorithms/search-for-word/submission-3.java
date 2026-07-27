class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(board, i, j, m, n, 0, word, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, int m, int n, int idx,
                            String word, boolean[][] visited){
        if(idx == word.length()) return true;
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(idx))
            return false;
        

        visited[i][j] = true;
        boolean ans =  helper(board, i + 1, j, m, n, idx + 1, word, visited)
            || helper(board, i - 1, j, m, n, idx + 1, word, visited)
            || helper(board, i, j + 1, m, n, idx + 1, word, visited)
            || helper(board, i, j - 1, m, n, idx + 1, word, visited);
        visited[i][j] = false;
        return ans;
    }
}
