package test;

/**
 * @author LeiDongxing
 * created on 2021/3/14
 * 实现 Trie (前缀树)
 * 找到具有同一前缀的全部键值。
 * 按词典序枚举字符串的数据集。
 */
public class Trie {
    private boolean isString = false;
    private Trie[] next = new Trie[26];

    public Trie() {

    }

    public void insert(String word) {
        Trie root = this;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (root.next[w[i] - 'a'] == null) {
                root.next[w[i] - 'a'] = new Trie();
            }
            root = root.next[w[i] - 'a'];
        }
        root.isString = true;
    }

    public boolean search(String word) {
        Trie root = this;
        char[] w = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (root.next[w[i] - 'a'] == null) {
                return false;
            }
            root = root.next[w[i] - 'a'];
        }
        return root.isString;
    }

    public boolean startsWith(String prefix) {
        Trie root = this;
        char[] p = prefix.toCharArray();
        for (int i = 0; i < p.length; i++) {
            if (root.next[p[i] - 'a'] == null) {
                return false;
            }
            root = root.next[p[i] - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));//true
        System.out.println(trie.search("app"));//false
        System.out.println(trie.startsWith("app"));//true
        trie.insert("app");
        System.out.println(trie.search("app"));//true
    }
}
