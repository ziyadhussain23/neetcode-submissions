class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()) return new ArrayList<>();
       String[] num = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        helper(digits, 0, num, new StringBuilder(), res);
        return res;
    }

    private void helper(String s, int idx, String[] num, StringBuilder cur, List<String> res){
        if(idx == s.length()){
            res.add(cur.toString());
            return;
        }

        for(char c : num[s.charAt(idx) - '0'].toCharArray()){
            cur.append(c);
            helper(s, idx + 1, num, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
