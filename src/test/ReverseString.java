package test;

/**
 * 反转字符串
 */
public class ReverseString {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        return sb.append(chars).toString();
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }

    /**
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     */
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            reverse(array, i, Math.min(i + k, s.length()) - 1);
        }
        return new String(array);
    }

    public void reverse(char[] array, int left, int right) {
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverseString("hello"));
        System.out.println(rs.reverseString("A man, a plan, a canal: Panama"));
        System.out.println(rs.reverseStr("abcdefg", 2)); //bacdfeg
        System.out.println(rs.reverseStr("abcd", 2));//bacd
        System.out.println(rs.reverseStr("abcdefg", 8));//gfedcba
    }
}
