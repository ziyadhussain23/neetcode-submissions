class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }

    private boolean valid(String s, int l, int r){
        while(l < r) if(s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    private void helper(String s, int st, List<String> cur, List<List<String>> res){
        if(st == s.length()){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = st + 1; i <= s.length(); i++){
            if(valid(s, st, i - 1)){
                cur.add(s.substring(st, i));
                helper(s, i, cur, res);
                cur.removeLast();
            }
        }
    }


    // private boolean valid(String s){
    //     if(s.isEmpty()) return false;
    //     for(int i = 0, j = s.length() - 1; i < j; i++, j--){
    //         if(s.charAt(i) != s.charAt(j)) return false;
    //     }
    //     return true;
    // }

    // private void helper(String s, int st, int idx, List<String> cur, List<List<String>> res){
    //     String sub = st < s.length() && idx <= s.length() ? s.substring(st, idx) : "";
    //     if(idx == s.length()){
    //         if(valid(sub)){
    //             cur.add(sub);
    //             res.add(new ArrayList<>(cur));
    //             cur.removeLast();
    //         }
    //         return;
    //     }

    //     if(valid(sub)){
    //         cur.add(sub);
    //         helper(s, idx, idx, cur, res);
    //         cur.removeLast();
    //     }
    //     helper(s, st, idx + 1, cur, res);
    // }
}
