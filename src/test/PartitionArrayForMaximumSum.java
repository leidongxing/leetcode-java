package test;

/**
 * @author LeiDongxing
 * created on 2021/3/21
 * 分隔数组以得到最大和
 */
public class PartitionArrayForMaximumSum {
    /*
     * 分割长度最多为k
     * 1 <= k <= arr.length
     */
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        //dp[i]前i个元素合理分配的最大值
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = i - 1; (i - j) <= k && j >= 0; j--) {
                max = Math.max(max, arr[j]);
                dp[i] = Math.max(dp[i], dp[j] + (i - j) * max);
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        PartitionArrayForMaximumSum p = new PartitionArrayForMaximumSum();
        System.out.println(p.maxSumAfterPartitioning(new int[]{1, 15, 7}, 2));
        // System.out.println(p.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));//84
//        System.out.println(p.maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));//83
//        System.out.println(p.maxSumAfterPartitioning(new int[]{1}, 1));//1
    }
}
