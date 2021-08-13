package test;

/**
 * @author LeiDongxing
 * created on 2021/6/18
 * 最小好进制
 * 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称 k（k>=2）是 n 的一个好进制。
 */
public class SmallestGoodBase {
    public String smallestGoodBase(String n) {
        long m = Long.parseLong(n);
        int max = (int) (Math.log(m) / Math.log(2) + 1);
        for (int len = max; len >= 3; len--) {
            long k = (long) Math.pow(m, 1.0 / (len - 1));
            long res = 0;
            for (int i = 0; i < len; i++) {
                res = res * k + 1;
            }
            if (res == m) {
                return String.valueOf(k);
            }
        }
        return String.valueOf(m - 1);
    }
}
