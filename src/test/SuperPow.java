package test;

/**
 * @author LeiDongxing
 * created on 2021/12/5
 * 超级次方
 */
public class SuperPow {
    private static final int MOD = 1337;

    /**
     * @param a 正整数
     * @param b b是一个非常大的正整数且会以数组形式给出
     * @return 对1337取模
     */
    public int superPow(int a, int[] b) {
        return dfs(a % MOD, b, b.length - 1);
    }

    private int dfs(int a, int[] b, int idx) {
        if (idx == -1 || a == 1) {
            return 1;
        }
        return qPow(dfs(a, b, idx - 1), 10) * qPow(a, b[idx]) % MOD;
    }

    private int qPow(int a, int b) {
        int result = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) != 0)
                result = result * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return result;
    }
}
