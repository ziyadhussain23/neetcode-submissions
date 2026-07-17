class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if(l2 < l1) return false;
        int[] cnt = new int[26], cnt2 = new int[26];
        for(int i = 0; i < l1; i++){
            char c = s1.charAt(i);
            char ch = s2.charAt(i);
            cnt[c - 'a']++;
            cnt2[ch - 'a']++;
        }
        if(Arrays.equals(cnt, cnt2)) return true;
        int l = 0, r = l1;
        while(r < l2){
            char c = s2.charAt(l);
            char ch = s2.charAt(r);
            cnt2[c - 'a']--;
            cnt2[ch - 'a']++;
            l++;
            r++;
            if(Arrays.equals(cnt, cnt2)) return true;
        }
        return false;
    }
}
