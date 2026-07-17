class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int i : nums) hs.add(i);
        int ans = 0;
        for(int i : nums){
            if(!hs.contains(i - 1)){
                int cnt = 1;
                while(hs.contains(++i)) cnt++;
                ans = Math.max(ans, cnt);
            }
        }
        return ans;

    }
    
    // public int longestConsecutive(int[] nums) {
    //     if(nums == null || nums.length == 0) return 0;
    //     Arrays.sort(nums);
    //     int cnt = 1;
    //     int ans = 1;
    //     for(int i = 1; i < nums.length; i++){
    //         if(nums[i] == nums[i - 1]) continue;
    //         if(nums[i] - nums[i - 1] == 1) cnt++;
    //         else{
    //             ans = Math.max(ans, cnt);
    //             cnt = 1;
    //         }
    //     }
    //     ans = Math.max(ans, cnt);
    //     return ans;
    // }
}
