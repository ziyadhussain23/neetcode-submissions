class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, int idx, List<Integer> cur, List<List<Integer>> res){
        if(idx == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        // for(int i = idx; i < nums.length; i++){
        //     while(i > idx && nums[i] == nums[i - 1]) i++;

        //     cur.add(nums[i]);
        //     helper(nums, i + 1, cur, res);
        //     cur.removeLast();
        //     helper(nums, i + 1, cur, res);
        // }

        cur.add(nums[idx]);
        helper(nums, idx + 1, cur, res);
        cur.removeLast();

        while(idx + 1 < nums.length && nums[idx] == nums[idx + 1]) idx++;
        helper(nums, idx + 1, cur, res);
    }
}
