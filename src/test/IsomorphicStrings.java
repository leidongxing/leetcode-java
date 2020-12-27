package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LeiDongxing
 * created on 2020/12/27
 * 同构字符串
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i)) && !map1.get(s.charAt(i)).equals(t.charAt(i))) {
                return false;
            }
            if (map2.containsKey(t.charAt(i)) && !map2.get(t.charAt(i)).equals(s.charAt(i))) {
                return false;
            }
            map1.put(s.charAt(i), t.charAt(i));
            map2.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] preIndexOfs = new int[256];
        int[] preIndexOft = new int[256];
        for (int i = 0; i < chars.length; i++) {
            if (preIndexOfs[chars[i]] != preIndexOft[chart[i]]) {
                return false;
            }
            preIndexOfs[chars[i]] = i + 1;
            preIndexOft[chart[i]] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("ab", "aa"));
        System.out.println(new IsomorphicStrings().isIsomorphic("egg", "add"));
        System.out.println(new IsomorphicStrings().isIsomorphic("foo", "bar"));
        System.out.println(new IsomorphicStrings().isIsomorphic("paper", "title"));
    }
}
