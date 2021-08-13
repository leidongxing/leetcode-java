package test;

import java.util.Collections;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/3/14
 * 单词搜索II
 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        WordSearchII ws = new WordSearchII();
        System.out.println(ws.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain" }));
        System.out.println(ws.findWords(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abcd" }));
    }
}
