class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for(String s : strs){
            int[] cnt = new int[26];
            for(char c : s.toCharArray()) cnt[c - 'a']++;
            String key = Arrays.toString(cnt);
            hm.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(hm.values());
    }
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     Map<String, List<String>> hm = new HashMap<>();
    //     for(String s : strs){
    //         char[] ch = s.toCharArray();
    //         Arrays.sort(ch);
    //         String key = new String(ch);
    //         hm.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
    //     }
    //     return new ArrayList<>(hm.values());
    // }
}
