package test;

/**
 * @author LeiDongxing
 * created on 2021/2/28
 * 外观数列
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();

        int lastIndex = 0;
        char last = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != last) {
                sb.append(i - lastIndex);
                sb.append(last - '0');
                last = s.charAt(i);
                lastIndex = i;
            }
        }
        sb.append(s.length() - lastIndex);
        sb.append(last - '0');
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(1));//1
        System.out.println(new CountAndSay().countAndSay(2));//11
        System.out.println(new CountAndSay().countAndSay(3));//21
        System.out.println(new CountAndSay().countAndSay(4));//1211
        System.out.println(new CountAndSay().countAndSay(5));//111221
        System.out.println(new CountAndSay().countAndSay(6));//312211
        System.out.println(new CountAndSay().countAndSay(7));//13112221
        System.out.println(new CountAndSay().countAndSay(8));//1113213211
        System.out.println(new CountAndSay().countAndSay(9));//31131211131221
        System.out.println(new CountAndSay().countAndSay(10));//13211311123113112211
    }
}
