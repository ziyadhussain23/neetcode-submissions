class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, n = s.length(), ans = 0;
        boolean[] seen = new boolean[257];
        while(r < n){
            char c = s.charAt(r);
            while(l < r && seen[c]){
                char ch = s.charAt(l);
                seen[ch] = false;
                l++;
            }
            r++;
            seen[c] = true;
            ans = Math.max(ans , r - l);
        }
        return ans;
    }
}
