package test;

/**
 * @author LeiDongxing
 * created on 2021/8/8
 * 第N个泰波那契数
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 */
public class NThTribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else {
            int a = 0;
            int b = 1;
            int c = 1;
            int tmp = -1;
            for (int i = 3; i <= n; i++) {
                tmp = a + b + c;
                a = b;
                b = c;
                c = tmp;
            }
            return tmp;
        }
    }

    public int tribonacci1(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            return dp[n];
        }
    }
}
