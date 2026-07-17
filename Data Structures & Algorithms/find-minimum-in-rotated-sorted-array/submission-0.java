class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = (l + r) >> 1;
            System.out.println(l + " " + r);
            if(nums[mid] >= nums[l] && nums[mid] < nums[r]) r = mid;
            else if(nums[mid] >= nums[l] & nums[mid] > nums[r]) l = mid + 1;
            else if(nums[mid] < nums[l] && nums[mid] < nums[r]) r = mid;
            else l = mid + 1;
        }
        return nums[l];
    }
}
