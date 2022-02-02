public class TrieNode {
    static final int ALPHABET_SIZE = 26;
    private boolean isEndOfWord;
    private TrieNode[] children;

    TrieNode() {
        this.isEndOfWord = false;
        this.children = new TrieNode[ALPHABET_SIZE];
    }
    public boolean getIsEndOfWord(){
        return this.isEndOfWord;
    }
    public void setIsEndOfWord(boolean isEndOfWord){
        this.isEndOfWord = isEndOfWord;
    }
    public TrieNode[] getTrieNode(){
        return this.children;
    }
    public void setTrieNode(TrieNode[] children){
        this.children = children;
    }

}