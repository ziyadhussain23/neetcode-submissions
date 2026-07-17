class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, n = s.length(), ans = 0;
        int[] seen = new int[256];
        Arrays.fill(seen, -1);
        while(r < n){
            char c = s.charAt(r);
            if(seen[c] >= 0){
                l = Math.max(seen[c] + 1, l);
            }
            seen[c] = r;
            r++;
            ans = Math.max(ans , r - l);
        }
        return ans;
    }
}
