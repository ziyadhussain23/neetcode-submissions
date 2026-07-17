class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while(l < r){
            int mid = (l + r) >> 1;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) r = mid;
            else l = mid + 1;
        }
        return -1;
    }
}
