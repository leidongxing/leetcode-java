package test;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> currentMap = new HashMap<Character, Integer>();
        int maxLength = 0;
        int currentLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (currentMap.containsKey(s.charAt(i))) {
                currentLength = Math.max(currentLength, currentMap.get(s.charAt(i)) + 1);
            }
            currentMap.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - currentLength + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring los = new LengthOfLongestSubstring();
        System.out.println(los.lengthOfLongestSubstring(""));
        System.out.println(los.lengthOfLongestSubstring("abcabcbb")); //abc
        System.out.println(los.lengthOfLongestSubstring("bbbbb")); //b
        System.out.println(los.lengthOfLongestSubstring("pwwkew")); //wke
        System.out.println(los.lengthOfLongestSubstring("ckilbkd")); // ckilb    ilbkd
        System.out.println(los.lengthOfLongestSubstring("au"));  //au
        System.out.println(los.lengthOfLongestSubstring("aab")); //ab
        System.out.println(los.lengthOfLongestSubstring("abba")); //ab
    }
}
