package test;

/**
 * @author LeiDongxing
 * created on 2021/4/24
 * 组合总和 Ⅳ
 */
public class CombinationSumIV {
    /**
     * 从nums 中找出并返回总和为 target 的元素组合的个数
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIV c = new CombinationSumIV();
        System.out.println(c.combinationSum4(new int[]{1, 2, 3}, 4));//7
        System.out.println(c.combinationSum4(new int[]{9}, 3));//0
    }
}
