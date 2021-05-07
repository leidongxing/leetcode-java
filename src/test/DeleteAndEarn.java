package test;

/**
 * @author LeiDongxing
 * created on 2021/5/5
 * 删除并获得点数
 */
public class DeleteAndEarn {
    /**
     * 选择任意一个 nums[i] 删除它并获得 nums[i]的点数
     * 之后，你必须删除每个等于nums[i] - 1或 nums[i] + 1的元素
     * 1 <= nums[i] <= 10000
     */
    public int deleteAndEarn(int[] nums) {
        int[] trans = new int[10001];
        for (int num : nums) {
            trans[num] += num;
        }
        int[] dp = new int[10001];
        dp[1] = trans[1];
        for (int i = 2; i < trans.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + trans[i]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        DeleteAndEarn d = new DeleteAndEarn();
        System.out.println(d.deleteAndEarn(new int[]{3, 4, 2}));//4+2
        System.out.println(d.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));//3+3+3
        System.out.println(d.deleteAndEarn(new int[]{3, 3, 3, 3, 3, 3}));//18
    }
}
