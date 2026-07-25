class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for(char c : tasks) cnt[c - 'A']++;

        int max = 0, maxcnt = 0;
        for(int i : cnt){
            if(max < i){
                max = i;
                maxcnt = 1;
            }else if(max == i){
                maxcnt++;
            }
        }

        int time = (max - 1) * (n + 1) + maxcnt;
        return Math.max(tasks.length, time);
    }
}
