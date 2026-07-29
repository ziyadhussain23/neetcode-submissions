class WordDictionary {
    static class Trie{
        Trie[] child;
        boolean end;

        Trie(){
            child = new Trie[26];
            end = false;
        }
    }
    Trie head;

    public WordDictionary() {
        head = new Trie();
    }

    public void addWord(String word) {
        Trie t = head;
        for(char c : word.toCharArray()){
            if(t.child[c - 'a'] == null) t.child[c - 'a'] = new Trie();
            t = t.child[c - 'a'];
        }
        t.end = true;
    }

    public boolean search(String word) {
        return helper(word, 0, head);
    }

    private boolean helper(String s, int i, Trie t) {
        if (i == s.length()) return t.end;

        char c = s.charAt(i);

        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (t.child[j] != null && helper(s, i + 1, t.child[j])) {
                    return true;
                }
            }
            return false;
        } else {
            int idx = c - 'a';
            if (t.child[idx] == null) return false;
            return helper(s, i + 1, t.child[idx]);
        }
    }
}
