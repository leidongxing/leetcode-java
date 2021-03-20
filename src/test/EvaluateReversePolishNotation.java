package test;

import java.util.Stack;

/**
 * @author LeiDongxing
 * created on 2021/3/20
 * 逆波兰表达式求值
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            } else if ("-".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if ("*".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            } else if ("/".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
        System.out.println(e.evalRPN(new String[]{"2", "1", "+", "3", "*"}));//((2 + 1) * 3) = 9
        System.out.println(e.evalRPN(new String[]{"4", "13", "5", "/", "+"}));//(4 + (13 / 5)) = 6
        System.out.println(e.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));//((10 * (6 / ((9 + 3) * -11))) + 17) + 5=22
    }
}
