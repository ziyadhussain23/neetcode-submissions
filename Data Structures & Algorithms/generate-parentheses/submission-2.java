class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, 0, new StringBuilder(), res);
        return res;
    }

    private void helper(int n, int cnt, StringBuilder str, List<String> res){
        if(str.length() == 2 * n){
            if(cnt == 0) res.add(str.toString());
            return;
        }

        str.append('(');
        helper(n, cnt + 1, str, res);
        str.setLength(str.length() - 1);
        if(cnt > 0){
            str.append(')');
            helper(n, cnt - 1, str, res);
            str.setLength(str.length() - 1);
        }
    }
}
