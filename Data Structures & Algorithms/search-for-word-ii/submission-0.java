class Solution {
    static class Trie{
        boolean end;
        Trie[] child;

        Trie(){
            child = new Trie[26];
            end = false;
        }
    }

    private void insert(String word, Trie head) {
        Trie t = head;
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(t.child[idx] == null){
                t.child[idx] = new Trie();
            }
            t = t.child[idx];
        }
        t.end = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Trie t = new Trie();
        for(String w : words){
            insert(w, t);
        }
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c = board[i][j];
                if(t.child[c - 'a'] != null){
                    helper(board, i, j, m, n, t, vis, new StringBuilder(), res);
                }
            }
        }
        return res;
    }

    private void helper(char[][] board, int i, int j, int m, int n, Trie t, 
                        boolean[][] vis, StringBuilder str, List<String> res){
        if(i < 0 || i >= m || j < 0 || j >= n || vis[i][j] || t == null) return;
        
        char c = board[i][j];
        if(t.child[c - 'a'] == null) return;

        str.append(c);
        t = t.child[c - 'a'];
        if(t.end){
            res.add(str.toString());
            t.end = false;
        }


        vis[i][j] = true;
        helper(board, i + 1, j, m, n, t, vis, str, res);
        helper(board, i - 1, j, m, n, t, vis, str, res);
        helper(board, i, j + 1, m, n, t, vis, str, res);
        helper(board, i, j - 1, m, n, t, vis, str, res);
        str.deleteCharAt(str.length() - 1);
        vis[i][j] = false;
    }
}
