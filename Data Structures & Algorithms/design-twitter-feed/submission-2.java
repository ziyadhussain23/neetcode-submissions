class Twitter {
    Map<Integer, Set<Integer>> follower;
    Map<Integer, List<int[]>> tweet;
    int timer;


    public Twitter() {
        follower = new HashMap<>();
        tweet = new HashMap<>();
        timer = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timer++;
        tweet.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{tweetId, timer});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[3] - a[3]);

        List<int[]> ls = tweet.get(userId);
        if(ls != null) pq.offer(new int[]{userId, ls.getLast()[0], 
                        ls.size() - 1, ls.getLast()[1]});

        for(int f : follower.getOrDefault(userId, new HashSet<>())){
            List<int[]> ls2 = tweet.get(f);
            if(ls2 != null) pq.offer(new int[]{f, ls2.getLast()[0], 
                        ls2.size() - 1, ls2.getLast()[1]});
        }

        while(!pq.isEmpty() && ans.size() < 10){
            int[] cur = pq.poll();
            ans.add(cur[1]);

            List<int[]> ls2 = tweet.get(cur[0]);
            if(ls2 != null && cur[2] > 0) pq.offer(new int[]{cur[0], ls2.get(cur[2] - 1)[0], 
                                cur[2] - 1, ls2.get(cur[2] - 1)[1]});
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        follower.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        follower.computeIfPresent(followerId, (k, follows) -> {
            follows.remove(followeeId);
            return follows.isEmpty() ? null : follows;
        });
    }
}
