package test;

import java.util.LinkedList;
import java.util.List;

public class ValidParentheses {
    //( ) ,{ }, [ ]
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        List<Character> al = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (al.isEmpty()) {
                if (s.charAt(i) != '(' && s.charAt(i) != '{' && s.charAt(i) != '[') {
                    return false;
                }
                al.add(s.charAt(i));
            } else {
                if (s.charAt(i) == ')') {
                    if (al.get(al.size() - 1) != '(') {
                        return false;
                    }
                    al.remove(al.size() - 1);
                } else if (s.charAt(i) == '}') {
                    if (al.get(al.size() - 1) != '{') {
                        return false;
                    }
                    al.remove(al.size() - 1);
                } else if (s.charAt(i) == ']') {
                    if (al.get(al.size() - 1) != '[') {
                        return false;
                    }
                    al.remove(al.size() - 1);
                } else {
                    al.add(s.charAt(i));
                }
            }
        }
        if (al.isEmpty()) {
            return true;
        }
        return false;
    }

//	public boolean isValid(String s) {
//		Stack<Character> stack = new Stack<Character>();
//		for (char c : s.toCharArray()) {
//			if (c == '(')
//				stack.push(')');
//			else if (c == '{')
//				stack.push('}');
//			else if (c == '[')
//				stack.push(']');
//			else if (stack.isEmpty() || stack.pop() != c)
//				return false;
//		}
//		return stack.isEmpty();
//	}

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()"));
    }
}
