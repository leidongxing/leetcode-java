package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2021/2/10
 * 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 */
public class PermutationInString {
    //双指针版本
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']--;
        }

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            int x = s2.charAt(right) - 'a';
            count[x]++;
            while (count[x] > 0) {
                count[s2.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }

    //优化版本
    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] diff = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            diff[s1.charAt(i) - 'a']--;
            diff[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] != 0) {
                count++;
            }
        }
        if (count == 0) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            int o = s2.charAt(i - s1.length()) - 'a';
            int n = s2.charAt(i) - 'a';
            if (o == n) {
                continue;
            }
            //修改之前是0 差异增大
            if (diff[n] == 0) {
                count++;
            }
            diff[n]++;
            //修改之前是0 差异缩小
            if (diff[n] == 0) {
                count--;
            }

            if (diff[o] == 0) {
                count++;
            }
            diff[o]--;
            if (diff[o] == 0) {
                count--;
            }

            if (count == 0) {
                return true;
            }
        }
        return false;
    }

    //初始版本 依次比较
    public boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Array = new int[26];
        int[] s2Array = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Array[s1.charAt(i) - 'a']++;
            s2Array[s2.charAt(i) - 'a']++;
        }
        if (check(s1Array, s2Array)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            s2Array[s2.charAt(i) - 'a']++;
            s2Array[s2.charAt(i - s1.length()) - 'a']--;
            if (check(s1Array, s2Array)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int[] s1, int[] s2) {
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        PermutationInString p = new PermutationInString();
        System.out.println(p.checkInclusion("ab", "eidbaooo"));//true
        System.out.println(p.checkInclusion("ab", "eidboaoo"));//false
    }
}
