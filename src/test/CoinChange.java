package test;

/**
 * @author LeiDongxing
 * created on 2021/6/10
 * 零钱兑换
 */
public class CoinChange {
    /**
     * 假设每一种面额的硬币有无限个
     *
     * @param amount 不同面额的硬币
     * @param coins  一个总金额
     * @return 可以凑成总金额的硬币组合数
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.change(5, new int[]{1, 2, 5}));
        System.out.println(cc.change(3, new int[]{2}));
        System.out.println(cc.change(10, new int[]{10}));
    }
}
