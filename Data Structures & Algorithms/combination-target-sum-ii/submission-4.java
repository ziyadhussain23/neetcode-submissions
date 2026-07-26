class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, int target, int idx, int sum, List<Integer> cur, List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(idx >= nums.length || sum > target) return;

        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i - 1]) continue;
            if(sum + nums[i] > target) break;
            cur.add(nums[i]);
            helper(nums, target, i + 1, sum + nums[i], cur, res);
            cur.removeLast();
        }
    }
}
