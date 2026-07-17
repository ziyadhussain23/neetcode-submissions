class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1, b = nums2;
        if(a.length > b.length){
            int[] temp = a;
            a = b;
            b = temp;
        }
        int m = a.length, n = b.length;
        int total = m + n;
        int half = total / 2;

        int l = 0, r = m - 1;
        while(true){
            int mid = (l + r) >> 1;
            int mid2 = half - mid - 2;

            int aleft = mid >= 0 ? a[mid] : Integer.MIN_VALUE;
            int aright = mid + 1 < m ? a[mid + 1] : Integer.MAX_VALUE;
            int bleft = mid2 >= 0 ? b[mid2] : Integer.MIN_VALUE;
            int bright = mid2 + 1 < n ? b[mid2 + 1] : Integer.MAX_VALUE;

            if(aleft <= bright && bleft <= aright){
                if(total % 2 == 1) return (double)Math.min(aright, bright);
                else return (Math.max(aleft, bleft) + Math.min(aright, bright)) / 2.0;
            }else if(aleft > bright) r = mid - 1;
            else l = mid + 1;
        }
        
        //return -1d;
    }
}
