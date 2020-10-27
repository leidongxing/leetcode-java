package test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author LeiDongxing
 * created on 2020/10/27
 * 前K个高频单词
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(k, (o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return -o1.compareTo(o2);
            } else {
                return map.get(o1) - map.get(o2);
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry.getKey());
            if (queue.size() > k) {
                queue.poll();
            }
        }
        String[] str = new String[k];
        for (int i = 1; i <= str.length; i++) {
            str[k - i] = queue.poll();
        }
        return Arrays.asList(str);
    }

    public static void main(String[] args) {
        TopKFrequentWords t = new TopKFrequentWords();
        System.out.println(t.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));//["i", "love"]
        System.out.println(t.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4)); //["the","is","sunny","day"]
    }
}
