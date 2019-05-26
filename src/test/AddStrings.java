package test;

import java.util.Stack;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        Stack<Integer> s = new Stack<Integer>();
        boolean goHead = false;
        char[] maxChar, minChar;
        if (num1.length() >= num2.length()) {
            maxChar = num1.toCharArray();
            minChar = num2.toCharArray();
        } else {
            minChar = num1.toCharArray();
            maxChar = num2.toCharArray();
        }
        int i = minChar.length - 1;
        int j = maxChar.length - 1;
        while (i >= 0) {
            int x = minChar[i] - '0';
            int y = maxChar[j] - '0';
            int curr;
            if (goHead) {
                curr = x + y + 1;
                if (curr < 10) {
                    s.push(curr);
                    goHead = false;
                } else {
                    curr = curr - 10;
                    s.push(curr);
                }
            } else {
                curr = x + y;
                if (x + y < 10) {
                    s.push(x + y);
                } else {
                    curr = curr - 10;
                    s.push(curr);
                    goHead = true;
                }
            }
            i--;
            j--;
        }

        while (j >= 0) {
            if (goHead) {
                if (maxChar[j] - '0' + 1 < 10) {
                    s.push(maxChar[j] - '0' + 1);
                    goHead = false;
                } else {
                    s.push(0);
                }
            } else {
                s.push(maxChar[j] - '0');
                goHead = false;
            }
            j--;
        }
        if (goHead) {
            s.push(1);
        }

        StringBuilder sb = new StringBuilder();
        while (!s.empty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddStrings ad = new AddStrings();
//		System.out.println(ad.addStrings("101", "4325"));
        System.out.println(ad.addStrings("408", "5"));
    }
}
