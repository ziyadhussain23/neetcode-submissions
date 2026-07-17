class TimeMap {
    Map<String, String> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        String k = key + " " + timestamp;
        hm.put(k, value);
    }
    
    public String get(String key, int timestamp) {
        String ans = "";
        while(timestamp > 0 && ans.isBlank()){
            ans = hm.getOrDefault(key + " " + timestamp, "");
            timestamp--;
        }
        return ans;
    }
}
