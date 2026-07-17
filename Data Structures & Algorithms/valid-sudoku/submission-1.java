class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] sq = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int val = (int)(board[i][j] - '1');
                    int box = (i / 3) * 3 + (j / 3);
                    if(row[i][val] || col[j][val] || sq[box][val]){
                        System.out.println(i + " " + j + " " + box + " " + val);
                        System.out.println(Arrays.deepToString(sq));
                        return false;
                    }
                    row[i][val] = true;
                    col[j][val] = true;
                    sq[box][val] = true;
                }
            }
        }
        return true;
    }
}
