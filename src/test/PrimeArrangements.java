package test;

/**
 * @author LeiDongxing
 * created on 2022/6/30
 * 质数排列
 * 质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 */
public class PrimeArrangements {
    private static final int MOD = 1000000007;

    /**
     * @param n
     * @return 返回答案模 mod 10^9 + 7之后的结果
     */
    public int numPrimeArrangements(int n) {
        int nums = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                nums++;
            }
        }
        return (int) (factorial(nums) * factorial(n - nums) % MOD);
    }

    /**
     * @param n
     * @return 是否为质数
     */
    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param n
     * @return n的阶乘取模
     */
    private long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res %= MOD;
        }
        return res;
    }

    public static void main(String[] args) {
        PrimeArrangements p = new PrimeArrangements();
        System.out.println(p.numPrimeArrangements(5)); //12
        System.out.println(p.numPrimeArrangements(100)); //682289015
    }
}
