package test;

import java.util.Stack;
import java.util.regex.Pattern;

public class BaseballGame {
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < ops.length; i++) {
            if (isNumeric(ops[i])) {
                s.push(Integer.valueOf(ops[i]));
            } else if ("C".equals(ops[i])) {
                s.pop();
            } else if ("D".equals(ops[i])) {
                s.push(2 * s.peek());
            } else if ("+".equals(ops[i])) {
                int last = s.peek();
                s.pop();
                int prelast = s.peek();
                s.push(last);
                s.push(last + prelast);
            }
        }

        while (!s.empty()) {
            sum += s.pop();
        }
        return sum;
    }

    boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+(.[0-9]+)?");
        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
        BaseballGame b = new BaseballGame();
        System.out.println(b.isNumeric("-1"));


//		System.out.println(b.calPoints(new String[] {"5","2","C","D","+"}));
        System.out.println(b.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }
}
