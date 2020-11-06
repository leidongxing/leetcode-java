package test;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2020/11/5
 * 单词接龙
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //endWord不在字典中 无法转换
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int result = 0;
        //记录已经使用word
        Set<String> used = new HashSet<>();
        //队列保存当前路径
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        used.add(beginWord);
        while (!queue.isEmpty()) {
            result++;
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String start = queue.poll();
                for (String s : wordList) {
                    // 已经遍历的不再重复遍历
                    if (used.contains(s)) {
                        continue;
                    }
                    // 不能转换的直接跳过
                    if (!hasOneDiffWord(start, s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return result + 1;
                    }
                    // 保存访问过的单词，同时把单词放进队列，用于下一层的访问
                    used.add(s);
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    public boolean hasOneDiffWord(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}
