package test;

import java.util.*;

/**
 * 串联所有单词的子串
 */
public class SubstringWithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int m = words.length;
        int w = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        out:
        for (int i = 0; i + m * w <= n; i++) {
            Map<String, Integer> cur = new HashMap<>();
            String sub = s.substring(i, i + m * w);
            for (int j = 0; j < sub.length(); j += w) {
                String item = sub.substring(j, j + w);
                if (!map.containsKey(item)) {
                    continue out;
                }
                cur.put(item, cur.getOrDefault(item, 0) + 1);
            }
            if (cur.equals(map)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationofAllWords sc = new SubstringWithConcatenationofAllWords();
        System.out.println(sc.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));  //[0,9]
    }
}
