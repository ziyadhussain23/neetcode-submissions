class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            char ch = t.charAt(i);
            cnt[c - 'a']++;
            cnt[ch - 'a']--;
        }
        for(int i : cnt) if(i != 0) return false;
        return true;
    }
}
