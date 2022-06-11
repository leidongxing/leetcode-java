package test;

/**
 * @author LeiDongxing
 * created on 2022/6/11
 * 将字符串翻转到单调递增
 * 以一些0（可能没有0）后面跟着一些1（也可能没有1）的形式组成的，那么该字符串是单调递增的。
 * 首个字符是0或1
 * 其余的每个字符，字符0前面的相邻字符一定是0，字符1前面的相邻字符可以是0或1。
 */
public class FlipStringToMonotoneIncreasing {
    //最后的目标序列形如 000...000、000...111 或 111...111
    //分割点idx左边有多少个 11（目标序列中分割点左边均为 00，因此 11 的个数为左边的改变次数）
    //分割点idx右边有多少个 00（目标序列中分割点右边均为 11，因此 00 的个数为右边的改变次数）
    //两者之和即是分割点为idx时的总变化次数，所有idx的总变化次数最小值
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] prefix_1 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix_1[i + 1] = prefix_1[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            result = Math.min(result, prefix_1[i] + (n - i) - (prefix_1[n] - prefix_1[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        FlipStringToMonotoneIncreasing f = new FlipStringToMonotoneIncreasing();
        System.out.println(f.minFlipsMonoIncr("00110")); //00111 1
        System.out.println(f.minFlipsMonoIncr("010110")); //011111 2   000111 2
        System.out.println(f.minFlipsMonoIncr("00011000")); //00000000  2
    }
}
