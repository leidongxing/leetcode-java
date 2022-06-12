package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2022/6/12
 * 查找和替换模式
 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            Map<Character, Character> map1 = new HashMap<>(pattern.length());
            Map<Character, Character> map2 = new HashMap<>(word.length());
            map1.put(pattern.charAt(0), word.charAt(0));
            map2.put(word.charAt(0), pattern.charAt(0));
            boolean isMatch = true;
            for (int i = 1; i < word.length(); i++) {
                char t1 = pattern.charAt(i);
                char t2 = word.charAt(i);
                if (map1.containsKey(t1) && map2.containsKey(t2)) {
                    if (map1.get(t1) != t2 || map2.get(t2) != t1) {
                        isMatch = false;
                        break;
                    }
                } else if (!map1.containsKey(t1) && !map2.containsKey(t2)) {
                    map1.put(t1, t2);
                    map2.put(t2, t1);
                } else {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAndReplacePattern f = new FindAndReplacePattern();
        System.out.println(f.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));  //"mee","aqq"
    }
}
