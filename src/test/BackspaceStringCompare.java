package test;

import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> ss = new Stack<Character>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#') {
                if (!ss.empty()) {
                    ss.pop();
                }

            } else {
                ss.push(c);
            }
        }
        StringBuilder ssb = new StringBuilder();
        while (!ss.empty()) {
            ssb.append(ss.pop());
        }
        Stack<Character> ts = new Stack<Character>();
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c == '#') {
                if (!ts.empty()) {
                    ts.pop();
                }

            } else {
                ts.push(c);
            }
        }
        StringBuilder tsb = new StringBuilder();
        while (!ts.empty()) {
            tsb.append(ts.pop());
        }

        return ssb.toString().equals(tsb.toString());
    }

    public static void main(String[] args) {
        BackspaceStringCompare bsc = new BackspaceStringCompare();
        System.out.println(bsc.backspaceCompare("ab#c", "ad#c"));
        System.out.println(bsc.backspaceCompare("ab##", "c#d#"));
        System.out.println(bsc.backspaceCompare("a##c", "#a#c"));
        System.out.println(bsc.backspaceCompare("a#c", "b"));
        System.out.println(bsc.backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
