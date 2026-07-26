class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, int target, int idx, int sum, List<Integer> cur,
                        List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = idx; i < nums.length; i++){
            if(sum + nums[i] > target) return;
            cur.add(nums[i]);
            helper(nums, target, i, sum + nums[i], cur, res);
            cur.removeLast();
        }
    }

    
}
