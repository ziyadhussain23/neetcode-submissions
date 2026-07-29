class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] chess = new char[n][n];
        for(char[] c : chess){
            Arrays.fill(c, '.');
        }
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        helper(0, n, chess, col, diag1, diag2, res);
        return res;
    }

    private void helper(int r, int n, char[][] chess, boolean[] col,
                        boolean[] diag1, boolean[] diag2, List<List<String>> res){
        if(r == n){
            List<String> ls = new ArrayList<>();
            for(char[] c : chess) ls.add(new String(c));
            res.add(ls);
            return;
        }

        for(int c = 0; c < n; c++){
            int d1 = r - c + n - 1;
            int d2 = r + c;
            if(col[c] || diag1[d1] || diag2[d2]) continue;

            chess[r][c] = 'Q';
            col[c] = diag1[d1] = diag2[d2] = true;
            
            helper(r + 1, n, chess, col, diag1, diag2, res);

            chess[r][c] = '.';
            col[c] = diag1[d1] = diag2[d2] = false;
        }
    }



    // private boolean valid(char[][] chess, int r, int c, int n){
    //     for(int i = 0; i < n; i++){
    //         if(chess[r][i] != '.') return false;
    //         if(chess[i][c] != '.') return false;
    //     }
    //     int i = r, j = c;
    //     while(i >= 0 && j >= 0){
    //         if(chess[i][j] != '.') return false;
    //         i--;
    //         j--;
    //     }
    //     i = r; j = c;
    //     while(i >= 0 && j < n){
    //         if(chess[i][j] != '.') return false;
    //         i--;
    //         j++;
    //     }
    //     i = r; j = c;
    //     while(i < n && j >= 0){
    //         if(chess[i][j] != '.') return false;
    //         i++;
    //         j--;
    //     }
    //     i = r; j = c;
    //     while(i < n && j < n){
    //         if(chess[i][j] != '.') return false;
    //         i++;
    //         j++;
    //     }
    //     return true;
    // }

    // private void helper(char[][] chess, int r, int c, int cnt, int n, Set<List<String>> res){
    //     if(r >= n || c >= n) return;
    //     if(cnt == n){
    //         List<String> ls = new ArrayList<>();
    //         for(char[] ch : chess) ls.add(new String(ch));
    //         //System.out.println(ls);
    //         res.add(ls);
    //         return;
    //     }

    //     for(int i = 0; i < n; i++){
    //         for(int j = 0; j < n; j++){
    //             if(valid(chess, i, j, n)){
    //                 chess[i][j] = 'Q';
    //                 helper(chess, i, j, cnt + 1, n, res);
    //                 chess[i][j] = '.';
    //             }
    //         }
    //     }
    // }
}
