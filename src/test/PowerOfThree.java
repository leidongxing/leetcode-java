package test;

/**
 * @author LeiDongxing
 * created on 2021/9/23
 * 3的幂
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }


    public boolean isPowerOfThree1(int n) {
        if (n == 1) {
            return true;
        } else if (n < 3) {
            return false;
        } else {
            while (n >= 3) {
                if (n % 3 != 0) {
                    return false;
                } else {
                    n = n / 3;
                }
            }
            return n == 1;
        }
    }
}
