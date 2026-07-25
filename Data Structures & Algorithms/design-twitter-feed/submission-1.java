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

        if (tweet.containsKey(userId) && !tweet.get(userId).isEmpty())
            pq.offer(new int[]{userId, 
                tweet.get(userId).get(tweet.get(userId).size() - 1)[0], 
                tweet.get(userId).size() - 1, 
                tweet.get(userId).get(tweet.get(userId).size() - 1)[1]});

        for (int u : follower.getOrDefault(userId, new HashSet<>()))
            if (tweet.containsKey(u) && !tweet.get(u).isEmpty())
                pq.offer(new int[]{u, tweet.get(u).get(tweet.get(u).size() - 1)[0], 
                tweet.get(u).size() - 1, tweet.get(u).get(tweet.get(u).size() - 1)[1]});

        while (!pq.isEmpty() && ans.size() < 10) {
            int[] x = pq.poll();
            ans.add(x[1]);
            if (x[2] > 0)
                pq.offer(new int[]{x[0], tweet.get(x[0]).get(x[2] - 1)[0], x[2] - 1, 
                tweet.get(x[0]).get(x[2] - 1)[1]});
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
