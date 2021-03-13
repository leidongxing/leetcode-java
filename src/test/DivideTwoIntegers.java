package test;

/**
 * 两数相除
 */
public class DivideTwoIntegers {
    /**
     * @param dividend 被除数
     * @param divisor 除数
     * @return 商
     */
    public int divide(int dividend, int divisor) {
        //被除数为0
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative = (dividend ^ divisor) < 0;
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            //找出最够大的数
            if ((t >> i) >= d) {
                //结果加上
                result += 1 << i;
                // 被除数减去
                t -= d << i;
            }
        }
        return negative ? -result : result;
    }
}
