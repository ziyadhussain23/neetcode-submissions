class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int cnt = 0;
        for(int i : nums){
            if(i == 0){
                cnt++;
            }else{
                mul *= i;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(cnt == 0){
                nums[i] = mul / nums[i];
            }else{
                if(cnt > 1){
                    nums[i] = 0;
                }else{
                    if(nums[i] == 0) nums[i] = mul;
                    else nums[i] = 0;
                }
            }
        }
        return nums;
    }
}  
