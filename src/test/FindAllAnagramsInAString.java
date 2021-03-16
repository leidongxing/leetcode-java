package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/3/12
 * 找到字符串中所有字母异位词
 */
public class FindAllAnagramsInAString {
    /**
     * 找出s中所有是p的字母异位词 返回起始索引
     */
    public List<Integer> findAnagrams(String s, String p) {
        //记录p的所有字母及其个数
        char[] need = new char[26];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i) - 'a']++;
        }

        int left = 0, right = 0;
        char[] window = new char[26];
        List<Integer> result = new ArrayList<>();
        while (right < s.length()) {
            window[s.charAt(right) - 'a']++;
            //字母异位词 长度相同 维护一个长度为p.length()的窗口
            while (right - left + 1 == p.length()) {
                if (Arrays.equals(window, need)) {
                    result.add(left);
                }
                window[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return result;
    }


    public static void main(String[] args) {
        FindAllAnagramsInAString f = new FindAllAnagramsInAString();
        System.out.println(f.findAnagrams("cbaebabacd", "abc"));//[0, 6]
        System.out.println(f.findAnagrams("abab", "ab"));//[0, 1, 2]
    }
}
