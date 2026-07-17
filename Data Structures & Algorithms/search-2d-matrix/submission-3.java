class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        while(l <= r){
            int mid = (l + r) >> 1;
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] > target) r = mid - 1;
            else l = mid + 1;
        }
        int cur = r;
        // if(matrix[cur][0] > target) cur--;
        if(cur == -1) return false;
        //System.out.println(cur);
        l = 0; r = matrix[0].length;
        while(l < r){
            int mid = (l + r) >> 1;
            if(matrix[cur][mid] == target) return true;
            else if(matrix[cur][mid] > target) r = mid;
            else l = mid + 1;
        }
        return false;
    }
}
