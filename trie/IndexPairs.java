import java.util.ArrayList;
import java.util.List;

public class IndexPairs {
    static class Trie {
        boolean isEndOfWord;
        Trie[] children;

        public Trie() {
            this.isEndOfWord = false;
            this.children = new Trie[26];
        }
    }

    static Trie root = new Trie();

    public void addWord(String word) {
        int n = word.length();
        Trie curr = root;
        for (int level = 0; level < n; level++) {
            int index = word.charAt(level) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Trie();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    public static void main(String[] args) {
        IndexPairs obj = new IndexPairs();
        String text = "thestoryofleetcodeandme";
        String[] words = {"story", "fleet", "leetcode" };
        // String text = "ababa";
        // String[] words = { "aba", "ab" };
        int[][] res = obj.indexPairs(text, words);
        System.out.println(String.valueOf(res));

    }

    public int[][] indexPairs(String text, String[] words) {
        /**
         * input: text = "ababa", words = ["aba", "ab"]
         * output: [[0, 1], [0, 2], [2, 3], [2, 4]]
         * Notice match can overlap, see "aba" is found [0, 2] and [2, 4]
         * 
         * input: text = "thestoryofleetcodeandme", words = ["story", "fleet",
         * "leetcode"]
         * output: [[3, 7], [9, 13], [10, 17]]
         */
        List<int[]> list = new ArrayList<>();
        int n = text.length();

        for (String word : words) {
            this.addWord(word);
        }

        for (int l = 0; l < n; l++) {
            Trie curr = root;
            int p = l;
            int index = text.charAt(l) - 'a';
            while (curr.children[index] != null) {
                curr = curr.children[index];
                if (curr.isEndOfWord) {/* there is a word ending here, put into our list */
                    list.add(new int[] { l, p });
                }
                p++;
                if (p == n) {/* reach the end of the text, we stop */
                    break;
                } else {
                    index = text.charAt(p) - 'a';
                }
            }

        }
        /* put all the pairs from list into array */
        int size = list.size();
        int[][] res = new int[size][2];
        int i = 0;
        for (int[] arr : list) {
            res[i] = arr;
            i++;
        }
        return res;
    }
}