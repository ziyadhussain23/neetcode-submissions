class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> hs = new HashSet<>();
        helper(nums, 0, hs, new ArrayList<>());
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> ls : hs){
            res.add(ls);
        }
        return res;
    }

    public void helper(int[] nums, int idx, Set<List<Integer>> res, List<Integer> cur){
        if(idx == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[idx]);
        helper(nums, idx + 1, res, cur);
        cur.removeLast();
        helper(nums, idx + 1, res, cur);
    }
}
