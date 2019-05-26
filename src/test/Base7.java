package test;

import java.util.Stack;

public class Base7 {
    public String convertToBase7(int num) {
        Stack<Character> s = new Stack<Character>();
        boolean isNegative = false;
        if (num < 0) {
            num = -num;
            isNegative = true;
        }
        while (num >= 7) {
            s.push(Character.forDigit(num % 7, 10));
            num = num / 7;
        }
        s.push(Character.forDigit(num % 7, 10));
        StringBuilder sb = new StringBuilder();
        if (isNegative) {
            sb.append('-');
        }
        while (!s.empty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Base7 b = new Base7();
        System.out.println(b.convertToBase7(-101));
        System.out.println(b.convertToBase7(-7));
        System.out.println(b.convertToBase7(7));
    }
}
