public class WordDictionary {
    //static variable
    static final int ALPHABET_SIZE = 26;
    /**
     * static nested classes
     */
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        TrieNode() {
            this.isEndOfWord = false;
            this.children = new TrieNode[WordDictionary.ALPHABET_SIZE];//access only the static members of the outer class
        }
    }
    //static variable
    static TrieNode root;
    // construction function
    public WordDictionary() {
        // inner class vs static nested class: instantiated without instantiating its outer class
        root = new TrieNode();
    }

    public void addWord(String word) {
        int n = word.length();
        int level;
        int index;
        TrieNode curr = root;
        for (level = 0; level < n; level++) {
            index = word.charAt(level) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return helper(word, root);
    }

    private boolean helper(String word, TrieNode root) {
        int level;
        int n = word.length();
        int index;
        TrieNode curr = root;
        for (level = 0; level < n; level++) {
            if (word.charAt(level) == '.') {
                for (int l = 0; l < ALPHABET_SIZE; l++) {
                    if (curr.children[l] != null) {
                        if (helper(word.substring(level + 1), curr.children[l])) {
                            return true;
                        }
                    }
                }
            } else {
                index = word.charAt(level) - 'a';
                if (curr.children[index] == null) {
                    return false;
                }
                curr = curr.children[index];
                continue;
            }
            return false;

        }
        if (curr.isEndOfWord) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        // obj.addWord("ab");
        // obj.addWord("a");
        // obj.addWord("bad");
        // obj.addWord("bag");
        obj.search("a");

    }
}