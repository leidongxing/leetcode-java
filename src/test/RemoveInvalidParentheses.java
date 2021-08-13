package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LeiDongxing
 * created on 2021/3/16
 * 删除无效的括号
 * 删除最小数量的无效括号，返回所有有效字符串可能的结果。
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> removed = new ArrayList<>();
        remove(s, removed, '(', ')', 0, 0);
        return removed;
    }

    private void remove(String s, List<String> removed, char opening, char closing, int i, int lastRemoved) {
        int count = 0;
        while (i < s.length() && count >= 0) {
            if (s.charAt(i) == opening) {
                count++;
            } else if (s.charAt(i) == closing) {
                count--;
            }
            i++;
        }
        if (count >= 0) {
            s = new StringBuilder(s).reverse().toString();
            if (opening == '(') {
                remove(s, removed, closing, opening, 0, 0);
            } else {
                removed.add(s);
            }
        } else {
            for (int j = lastRemoved; j < i; j++) {
                if (s.charAt(j) == closing && (j == 0 || s.charAt(j - 1) != closing)) {
                    remove(s.substring(0, j) + s.substring(j + 1), removed, opening, closing, i - 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses r = new RemoveInvalidParentheses();
        System.out.println(r.removeInvalidParentheses("()())()"));
        System.out.println(r.removeInvalidParentheses("(a)())()"));
        System.out.println(r.removeInvalidParentheses(")("));

    }
}
