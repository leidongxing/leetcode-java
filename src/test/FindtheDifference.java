package test;

import java.util.HashMap;
import java.util.Map;

public class FindtheDifference {
    public char findTheDifference(String s, String t) {
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();

        int asciis = 0;
        int asciit = 0;

        for (int i = 0; i < array1.length; i++) {
            asciis += (int) array1[i];
        }

        for (int i = 0; i < array2.length; i++) {
            asciit += (int) array2[i];
        }

        return (char) (asciit - asciis);
    }

    public char findTheDifference1(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < tChar.length; i++) {
            if (map.containsKey(tChar[i])) {
                map.put(tChar[i], map.get(tChar[i]) + 1);
            } else {
                map.put(tChar[i], 1);
            }
        }
        for (int j = 0; j < sChar.length; j++) {
            if (map.containsKey(sChar[j])) {
                int times = map.get(sChar[j]) - 1;
                if (times == 0) {
                    map.remove(sChar[j]);
                } else {
                    map.put(sChar[j], times);
                }
            }
        }
        return map.entrySet().iterator().next().getKey();
    }

    public static void main(String[] args) {
        FindtheDifference f = new FindtheDifference();
        System.out.println(f.findTheDifference("aa", "aac"));
    }
}
