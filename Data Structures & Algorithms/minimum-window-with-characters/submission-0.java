class Solution {
    public String minWindow(String s, String t) {
        int[] cnt = new int[256];
        int need = 0;
        for(char c : t.toCharArray()){
            if(cnt[c] == 0) need++;
            cnt[c]++;
        }
        int l = 0;
        int[] cnt2 = new int[256];
        int[] res = {-1, -1};
        int ans = Integer.MAX_VALUE;
        int have = 0;
        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            cnt2[c]++;
            if(cnt[c] > 0 && cnt2[c] == cnt[c]) have++;

            while(have == need){
                if((r - l + 1) < ans){
                    ans = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char cl = s.charAt(l);
                cnt2[cl]--;
                if(cnt[cl] > 0 && cnt2[cl] < cnt[cl]) have--;
                l++;
            }
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
