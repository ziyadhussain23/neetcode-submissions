class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int l = 0, r = n - 1;
        while(l < r){
            if(arr[l][0] + arr[r][0] == target){
                if(arr[l][1] < arr[r][1]) return new int[]{arr[l][1], arr[r][1]};
                return new int[]{arr[r][1], arr[l][1]};
            }
            else if(arr[l][0] + arr[r][0] > target) r--;
            else l++;
        }
        return new int[]{};
    }
}
