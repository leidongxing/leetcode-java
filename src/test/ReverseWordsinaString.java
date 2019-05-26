package test;

import java.util.Stack;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        char[] sChar = s.toCharArray();
        Stack<StringBuilder> st = new Stack<StringBuilder>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] == ' ') {
                if (sb.length() != 0) {
                    st.push(sb);
                    sb = new StringBuilder();
                }
            } else if (sChar[i] != ' ') {
                sb.append(sChar[i]);
            }
        }
        if (sb.length() != 0) {
            st.push(sb);
        }
        if (st.isEmpty()) {
            return "";
        } else {
            StringBuilder result = new StringBuilder();
            while (!st.empty()) {
                result.append(st.pop());
                result.append(" ");
            }
            return result.subSequence(0, result.length() - 1).toString();
        }
    }

    public static void main(String[] args) {
        ReverseWordsinaString rw = new ReverseWordsinaString();
        System.out.println("--" + rw.reverseWords("   ") + "--");
        System.out.println("--" + rw.reverseWords(" 1") + "--");
        System.out.println("--" + rw.reverseWords("1 ") + "--");
        System.out.println("--" + rw.reverseWords("the sky is blue") + "--");
    }
}
