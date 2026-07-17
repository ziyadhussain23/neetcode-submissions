class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int l = i + 1, r = n - 1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] == 0){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[l]);
                    ls.add(nums[r]);
                    res.add(ls);
                    l++;
                    r--;
                }else if(nums[i] + nums[l] + nums[r] > 0) r--;
                else l++;
            }
        }
        return new ArrayList<>(res);
    }
}
