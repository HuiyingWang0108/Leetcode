class Trie {
    private Trie[] children;
    private boolean isEndOfWord;

    public Trie() {
        children = new Trie[26];
        isEndOfWord = false;
    }

    public void insert(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null)
                curr.children[index] = new Trie();
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;

    }

    public boolean search(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        return curr.isEndOfWord;

    }

    public boolean startsWith(String prefix) {
        Trie curr = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        return true;

    }
}