package test;

/**
 * @author LeiDongxing
 * created on 2021/8/19
 * 反转字符串中的元音字母
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] tmp = s.toCharArray();
        while (left < right) {
            while (left < s.length() && isNotVowel(s.charAt(left))) {
                left++;
            }
            while (right >= 0 && isNotVowel(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                tmp[left] = s.charAt(right);
                tmp[right] = s.charAt(left);
                left++;
                right--;
            }
        }
        return new String(tmp);
    }

    private boolean isNotVowel(char c) {
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U';
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString r = new ReverseVowelsOfAString();
        System.out.println(r.reverseVowels(".,"));//
//        System.out.println(r.reverseVowels(" "));//
//        System.out.println(r.reverseVowels("hello"));//holle
//        System.out.println(r.reverseVowels("leetcode"));//leotcede
    }
}
