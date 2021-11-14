package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2021/11/14
 * 键值映射
 */
public class MapSum {
    class TrieNode {
        int val = 0;
        TrieNode[] next = new TrieNode[26];
    }

    TrieNode root;
    Map<String, Integer> map;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
            node.val += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return 0;
            }
            node = node.next[c - 'a'];
        }
        return node.val;
    }


//    private Map<String, Integer> sumMap;
//
//    public MapSum() {
//        sumMap = new HashMap<>(8);
//    }
//
//    /**
//     * @param key 字符串
//     * @param val 值 如果键key已经存在，那么原来的键值对将被替代成新的键值对。
//     */
//    public void insert(String key, int val) {
//        sumMap.put(key, val);
//    }
//
//    /**
//     * 返回所有以该前缀prefix开头的键key的值的总和。
//     */
//    public int sum(String prefix) {
//        int sum = 0;
//        for (Map.Entry<String, Integer> entry : sumMap.entrySet()) {
//            if (entry.getKey().startsWith(prefix)) {
//                sum += entry.getValue();
//            }
//        }
//        return sum;
//    }
}
