package test;

/**
 * @author LeiDongxing
 * created on 2021/3/27
 * 6和9组成的最大数字
 */
public class Maximum69Number {
    public int maximum69Number(int num) {
        String s = String.valueOf(num);
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                c[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(c));
    }

    public static void main(String[] args) {
        Maximum69Number m = new Maximum69Number();
        System.out.println(m.maximum69Number(9669));
        System.out.println(m.maximum69Number(9996));
        System.out.println(m.maximum69Number(9999));
    }
}
