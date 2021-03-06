package test;

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

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverseString("hello"));
        System.out.println(rs.reverseString("A man, a plan, a canal: Panama"));
    }
}
