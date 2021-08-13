package test;

/**
 * @author LeiDongxing
 * created on 2021/8/13
 * 数字1的个数
 */
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        long mulk = 1;
        int result = 0;
        for (int i = 0; n >= mulk; i++) {
            result += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return result;
    }
}
