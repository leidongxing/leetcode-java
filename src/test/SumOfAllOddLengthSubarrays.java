package test;

/**
 * @author LeiDongxing
 * created on 2021/8/29
 * 所有奇数长度子数组的和
 */
public class SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        int result = 0;
        for (int i = 1; i <= n; i += 2) {
            for (int j = 0; j + i - 1 < n; j++) {
                int r = j + i - 1;
                result += prefixSum[r + 1] - prefixSum[j];
            }
        }
        return result;
    }
}
