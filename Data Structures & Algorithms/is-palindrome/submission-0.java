class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        String str = s.toLowerCase();
        while(l < r){
            char c = str.charAt(l);
            char ch = str.charAt(r);
            if(!Character.isLetterOrDigit(c)){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(ch)){
                r--;
                continue;
            }
            if(c != ch) return false;
            l++;
            r--;
        }
        return true;
    }
}
