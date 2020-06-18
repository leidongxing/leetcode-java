package test;

import java.util.Stack;

/**
 * @author LeiDongxing
 * create on 2020/6/19 0:14
 * 125. 验证回文串
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
    public boolean isPalindrome1(String s) {
        if ("".equals(s)) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (left <= right && !(Character.isLetter(s.charAt(left)) || Character.isDigit(s.charAt(left)))) {
                left++;
            }
            while (left <= right && !(Character.isLetter(s.charAt(right)) || Character.isDigit(s.charAt(right)))) {
                right--;
            }
            if (left <= right) {
                if (Character.isLetter(s.charAt(left)) && Character.isLetter(s.charAt(right))) {
                    if (!(s.charAt(left) == s.charAt(right) || s.charAt(left) + 32 == s.charAt(right) || s.charAt(left) == s.charAt(right) + 32)) {
                        return false;
                    }
                } else if (Character.isDigit(s.charAt(left)) && Character.isDigit(s.charAt(right))) {
                    if (s.charAt(left) != s.charAt(right)) {
                        return false;
                    }
                } else {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        System.out.println(v.isPalindrome("0P"));//false
        System.out.println(v.isPalindrome(" ")); //true
        System.out.println(v.isPalindrome("A      man, a plan, a canal: Panama"));//true
        System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));//true
        System.out.println(v.isPalindrome("race a car"));//false
    }
}
