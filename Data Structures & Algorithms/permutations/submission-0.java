class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for(int i : nums) cur.add(i);
        helper(0, cur, res);
        return res;
    }

    private void helper(int idx, List<Integer> cur, List<List<Integer>> res){
        if(idx == cur.size()){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = idx; i < cur.size(); i++){
            swap(cur, idx, i);
            helper(idx + 1, cur, res);
            swap(cur, idx, i);
        }
    }

    private void swap(List<Integer> cur, int i, int j){
        int t = cur.get(i);
        cur.set(i, cur.get(j));
        cur.set(j, t);
    }
}
