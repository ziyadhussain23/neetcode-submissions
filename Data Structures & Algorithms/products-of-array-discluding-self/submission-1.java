class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int cnt = 0;
        for(int i : nums){
            if(i == 0) cnt++;
            else mul *= i;
        }
        if(cnt > 1) return new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(cnt > 0) nums[i] = nums[i] == 0 ? mul : 0;
            else nums[i] = mul / nums[i];
        }
        return nums;
    }
}  
