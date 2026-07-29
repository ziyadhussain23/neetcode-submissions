class PrefixTree {
    static class Trie{
        char val;
        boolean end;
        Trie[] next;

        Trie(char val){
            this.val = val;
            next = new Trie[26];
            end = false;
        }
    }
    Trie head;
    public PrefixTree() {
        head = new Trie('#');
    }

    public void insert(String word) {
        Trie t = head;
        for(char c : word.toCharArray()){
            if(t.next[c - 'a'] == null){
                t.next[c - 'a'] = new Trie(c);
            }
            t = t.next[c - 'a'];
        }
        t.end = true;
    }

    public boolean search(String word) {
        Trie t = head;
        for(char c : word.toCharArray()){
            if(t.next[c - 'a'] == null) return false;
            t = t.next[c - 'a'];
        }
        return t.end;
    }

    public boolean startsWith(String prefix) {
        Trie t = head;
        for(char c : prefix.toCharArray()){
            if(t.next[c - 'a'] == null) return false;
            t = t.next[c - 'a'];
        }
        return true;
    }
}
