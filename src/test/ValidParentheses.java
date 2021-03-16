package test;

import java.util.*;

/**
 * 有效的括号
 */
public class ValidParentheses {
    //( ) ,{ }, [ ]
    public boolean isValid(String s) {
        //不是偶数 一定无效
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<>(4);
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(c))) {
                    return false;
                }
                stack.pop();
            } else {
                // ( [ { 直接入栈
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()"));
    }
}
