package test;

import java.util.Arrays;

/**
 * @author LeiDongxing
 * created on 2020/5/31
 * 比特位计数
 * 奇数的1的个数 等于 偶数的1的个数+1
 * 偶数的1的个数 等于 偶数/2的1的个数  偶数/2=偶数右移1位 补0  >>1
 */
public class CountingBits {

    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 0; i <= num; i++) {
            //如果是最低位是0 偶数
            if ((i & 1) == 0) {
                dp[i] = dp[i >> 1];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        CountingBits cb = new CountingBits();
        System.out.println(Arrays.toString(cb.countBits(2)));//[0,1,1]
        System.out.println(Arrays.toString(cb.countBits(5)));//[0,1,1,2,1,2]
    }
}
