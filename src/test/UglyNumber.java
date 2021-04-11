package test;

/**
 * 丑数
 * 丑数 只包含质因数 2、3 和/或 5 的正整数。
 */
public class UglyNumber {
    /**
     * 判断数是否为丑数
     */
    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        } else if (num == 0) {
            return false;
        }

        while (num % 2 == 0) {
            num = num >> 1;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }

    /**
     * 返回第n个丑数
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i <= n; i++) {
            int A = 2 * dp[a];
            int B = 3 * dp[b];
            int C = 5 * dp[c];
            if (A < B && A < C) {
                dp[i] = A;
                a++;
            } else if (B < A && B < C) {
                dp[i] = B;
                b++;
            } else if (C < A && C < B) {
                dp[i] = C;
                c++;
            } else if (A == B && B == C) {
                dp[i] = A;
                a++;
                b++;
                c++;
            } else if (A == B) {
                dp[i] = A;
                a++;
                b++;
            } else if (A == C) {
                dp[i] = A;
                a++;
                c++;
            } else {
                dp[i] = B;
                b++;
                c++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UglyNumber un = new UglyNumber();
        // System.out.println(un.isUgly(14));
        // System.out.println(un.isUgly(1));
        // System.out.println(un.isUgly(7));
        // System.out.println(un.isUgly(10));
        System.out.println(un.nthUglyNumber(10));
    }
}
