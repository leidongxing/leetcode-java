package test;

import java.util.*;

/**
 * @author LeiDongxing
 * created on 2021/7/3
 * 根据字符出现频率排序
 */
public class SortCharactersByFrequency {
    /**
     * 桶排序
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (Character c : s.toCharArray()) {
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
            maxFreq = Math.max(maxFreq, frequency);
        }
        //创建从1到最大频率的buckets
        StringBuilder[] buckets = new StringBuilder[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuilder();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets[frequency].append(c);
        }

        StringBuilder result = new StringBuilder();
        for (int i = maxFreq; i > 0; i--) {
            StringBuilder bucket = buckets[i];
            int size = bucket.length();
            //该频率的每一个字符
            for (int j = 0; j < size; j++) {
                //重复频率次
                for (int k = 0; k < i; k++) {
                    result.append(bucket.charAt(j));
                }
            }
        }
        return result.toString();
    }

    public String frequencySort1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Character c = list.get(i);
            for (int j = 0; j < map.get(c); j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
