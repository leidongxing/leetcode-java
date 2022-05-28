package test;

/**
 * @author LeiDongxing
 * created on 2022/5/28
 * 删除最外层的括号
 */
public class RemoveOutermostParentheses {
    /**
     * @param s 为有效非空字符串  ""、"()"、"(())()"、"(()(()))"
     * @return x
     */
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                level--;
            }
            if (level > 0) {
                sb.append(c);
            }
            if (c == '(') {
                level++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveOutermostParentheses r = new RemoveOutermostParentheses();
        System.out.println(r.removeOuterParentheses("(()())(())")); //()()()
        System.out.println(r.removeOuterParentheses("(()())(())(()(()))")); //()()()()(())
        System.out.println(r.removeOuterParentheses("()()"));
    }
}
